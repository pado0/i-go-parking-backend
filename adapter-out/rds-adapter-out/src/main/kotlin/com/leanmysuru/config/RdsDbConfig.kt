package com.leanmysuru.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.support.TransactionSynchronizationManager
import javax.sql.DataSource

@EnableConfigurationProperties
@Configuration
// @Transactional을 찾아 트랜잭션 범위를 활성하화는 역할
@EnableTransactionManagement
// 보퐁 스프링부트에서 자동으로 처리하지만, 커스텀 엔티티 매니저, 트랜잭션 매니저를 등록할때 쓴다.
@EnableJpaRepositories(
    basePackages = ["com.leanmysuru"],
    entityManagerFactoryRef = "rdsEntityManager",
    transactionManagerRef = "rdsTransactionManager")
class RdsDbConfig {

    @Bean(name = ["writerDataSource"])
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.writer")
    // custom configuration specifies in code that Hikari should be used, app.datasource.type will have no effect in yaml
    fun writerDataSource():DataSource {
        return DataSourceBuilder
            .create()
            .build()
    }

    @Bean(name = ["readerDataSource"])
    @ConfigurationProperties(prefix = "spring.datasource.reader")
    fun readerDataSource():DataSource{
        return DataSourceBuilder
            .create()
            .build()
    }

    @Bean
    fun routingDataSource(): DataSource {
        val writer = writerDataSource()
        val reader = readerDataSource()

        val dataSourceMap = mutableMapOf<Any, Any>()
        dataSourceMap["writer"] = writer
        dataSourceMap["reader"] = reader

        val routingDataSource = RoutingDataSource()
        routingDataSource.setDefaultTargetDataSource(writer)
        routingDataSource.setTargetDataSources(dataSourceMap)
        routingDataSource.afterPropertiesSet()

        return routingDataSource
    }

    // https://velog.io/@e1psycongr00/Spring-Transactional%EA%B3%BC-entityManager-%EA%B4%80%EA%B3%84-%EB%B6%84%EC%84%9D%ED%95%98%EA%B8%B0
    @Bean
    fun rdsTransactionManager(rdsEntityManager: LocalContainerEntityManagerFactoryBean): JpaTransactionManager {
        return JpaTransactionManager(rdsEntityManager.`object`!!)
    }

    @Bean
    fun rdsEntityManager(
        jpaProperties: JpaProperties,
        hibernateProperties: HibernateProperties,
    ): LocalContainerEntityManagerFactoryBean {
        val entityManagerFactoryBuilder = EntityManagerFactoryBuilder(
            HibernateJpaVendorAdapter(),
            hibernateProperties.determineHibernateProperties(jpaProperties.properties, HibernateSettings()),
            null
        )

        return entityManagerFactoryBuilder
            .dataSource(routingDataSource())
            .packages("com.leanmysuru")
            .build()
    }
}

class RoutingDataSource: AbstractRoutingDataSource() {
    override fun determineCurrentLookupKey(): Any {
        if(TransactionSynchronizationManager.isCurrentTransactionReadOnly()){
            return "reader"
        }
        return "writer"
    }
}