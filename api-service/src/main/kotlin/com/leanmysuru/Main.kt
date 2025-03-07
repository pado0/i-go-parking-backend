package com.leanmysuru

import com.leanmysuru.annotation.EnableRdsAdapter
import com.leanmysuru.annotation.EnableWebAdapter
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableSecurity
@EnableRdsAdapter
@EnableWebAdapter
class ApiServiceApplication : SpringBootServletInitializer() {
  override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder =
    builder.sources(ApiServiceApplication::class.java)
}

fun main(args: Array<String>) {
  SpringApplication.run(ApiServiceApplication::class.java, *args)
}
