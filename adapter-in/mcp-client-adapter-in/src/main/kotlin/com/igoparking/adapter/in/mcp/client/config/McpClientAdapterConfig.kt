package com.igoparking.adapter.`in`.mcp.client.config

import com.igoparking.adapter.`in`.mcp.client.controller.ParkingLocationController
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

// @EnableUsecaseApi
@Configuration
@ComponentScan(basePackages = ["com.igoparking.adapter.in.mcp.client"])
class McpClientAdapterConfig {
    @Bean
    fun check(): String {
        println("진짜뜨나?")
        return ""
    }

    @Bean
    fun beanLogging(): CommandLineRunner =
        CommandLineRunner {
            println(">>> ComponentScan 잘 됐는지 확인: ${ParkingLocationController::class.qualifiedName}")
        }
}
