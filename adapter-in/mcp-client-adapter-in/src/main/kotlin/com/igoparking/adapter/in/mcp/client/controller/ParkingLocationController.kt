package com.igoparking.adapter.`in`.mcp.client.controller

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.ai.chat.prompt.PromptTemplate
import org.springframework.ai.tool.ToolCallbackProvider
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/parking")
class ParkingLocationController(
    chatClientBuilder: ChatClient.Builder,
    tools: ToolCallbackProvider,
) {
    private val chatClient: ChatClient =
        chatClientBuilder
            .defaultTools(tools)
            .build()

    @GetMapping // ("/location")
    fun findByAltitudeAndLongitude(
//        @RequestParam altitude: Long,
//        @RequestParam longitude: Long,
    ): String? {
        val pt =
            PromptTemplate(
                """
                Where is the nearest parking location
                with altitude 10 and longitude 1- ?
                """.trimIndent(),
            )
        val p: Prompt = pt.create(mapOf("altitude" to 10, "longitude" to 10))
        return chatClient
            .prompt(p)
            .call()
            .content()
    }
}
