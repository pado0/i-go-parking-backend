package com.igoparking.api

import com.igoparking.adapter.`in`.mcp.client.annotation.EnableMcpClientAdapter
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
@ConfigurationPropertiesScan
// @EnableRdsAdapter
@EnableMcpClientAdapter
class ApiApplication : SpringBootServletInitializer() {
    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder = builder.sources(ApiApplication::class.java)
}

fun main(args: Array<String>) {
    SpringApplication.run(ApiApplication::class.java, *args)
}
