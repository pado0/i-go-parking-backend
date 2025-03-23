package com.boilerplate.adapter.out.rds.config

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource
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

@FlywayDataSource
@EnableConfigurationProperties
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = ["com.boilerplate.adapter.out.rds.repository"],
    entityManagerFactoryRef = "rdsEntityManager",
    transactionManagerRef = "rdsTransactionManager")
class RdsDbConfig {

    @Bean(name = ["writerDataSource"])
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.writer")
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
        dataSourceMap[WRITER_DATABASE] = writer
        dataSourceMap[READER_DATABASE] = reader

        val routingDataSource = RoutingDataSource()
        routingDataSource.setDefaultTargetDataSource(writer)
        routingDataSource.setTargetDataSources(dataSourceMap)
        routingDataSource.afterPropertiesSet()

        return routingDataSource
    }

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
            .packages("com.boilerplate.adapter.out.rds")
            .build()
    }
}

class RoutingDataSource: AbstractRoutingDataSource() {
    override fun determineCurrentLookupKey(): Any {
        if(TransactionSynchronizationManager.isCurrentTransactionReadOnly()){
            return READER_DATABASE
        }
        return WRITER_DATABASE
    }
}

const val READER_DATABASE = "reader"
const val WRITER_DATABASE = "writer"