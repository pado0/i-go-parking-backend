package com.igoparking.adapter.`in`.mcp.client.annotation

import com.igoparking.adapter.`in`.mcp.client.config.McpClientAdapterConfig
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(McpClientAdapterConfig::class)
annotation class EnableMcpClientAdapter
