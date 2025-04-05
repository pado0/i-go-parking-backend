package com.igoparking.adapter.out.mcp.config

import com.igoparking.adapter.out.mcp.tool.ParkingLocationTool
import org.springframework.ai.tool.ToolCallbackProvider
import org.springframework.ai.tool.method.MethodToolCallbackProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class McpConfig {
    @Bean
    fun tools(parkingLocationTool: ParkingLocationTool?): ToolCallbackProvider =
        MethodToolCallbackProvider
            .builder()
            .toolObjects(parkingLocationTool)
            .build()
}
