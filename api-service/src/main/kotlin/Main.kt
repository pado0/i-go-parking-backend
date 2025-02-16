package com.leanmysuru

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@EnableSecurity
@SpringBootApplication
@ConfigurationPropertiesScan
class ApiApplication : SpringBootServletInitializer() {
  override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder =
    builder.sources(ApiApplication::class.java)
}

fun main(args: Array<String>) {
  SpringApplication.run(ApiApplication::class.java, *args)
}
