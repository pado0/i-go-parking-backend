package com.igoparking.adapter.`in`.mcp.server.config

import com.igoparking.application.api.annotation.EnableUsecaseApi
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@EnableUsecaseApi
@Configuration
@ComponentScan(basePackages = ["com.igoparking.adapter.in.mcp.server"])
class McpServerAdapterConfig
