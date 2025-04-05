package com.igoparking.api

import com.igoparking.adapter.`in`.mcp.server.annotation.EnableMcpServerAdapter
import com.igoparking.adapter.out.mcp.annotation.EnableMcpAdapter
import com.igoparking.adapter.out.rds.annotation.EnableRdsAdapter
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableRdsAdapter
@EnableMcpAdapter
@EnableMcpServerAdapter
class ApiApplication : SpringBootServletInitializer() {
    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder = builder.sources(ApiApplication::class.java)
}

fun main(args: Array<String>) {
    SpringApplication.run(ApiApplication::class.java, *args)
}
