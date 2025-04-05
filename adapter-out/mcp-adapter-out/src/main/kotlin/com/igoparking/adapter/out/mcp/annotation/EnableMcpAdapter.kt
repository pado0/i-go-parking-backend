package com.igoparking.adapter.out.mcp.annotation

import com.igoparking.adapter.out.mcp.config.McpConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import

@ComponentScan(basePackages = ["com.igoparking.adapter.out.mcp"])
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(McpConfig::class)
annotation class EnableMcpAdapter
