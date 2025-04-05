package com.igoparking.adapter.`in`.mcp.server.annotation

import com.igoparking.adapter.`in`.mcp.server.config.McpServerAdapterConfig
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(McpServerAdapterConfig::class)
annotation class EnableMcpServerAdapter
