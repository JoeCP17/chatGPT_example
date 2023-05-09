package com.example.chatgpt_example_kotlin.dto

import com.theokanning.openai.completion.chat.ChatCompletionRequest
import com.theokanning.openai.completion.chat.ChatMessage

data class CompletionChatDTO (
        val model: String,
        val role: String,
        val message: String,
        val maxToken: Int
        ){

        companion object {
                fun toCompletionChatRequest(request: CompletionChatDTO): ChatCompletionRequest {
                        return ChatCompletionRequest.builder()
                                .model(request.model)
                                .messages(getChatMessageBy(request.role, request.message))
                                .maxTokens(request.maxToken)
                                .build()
                }


                private fun getChatMessageBy(role: String, message: String): List<ChatMessage> {
                        return listOf(ChatMessage(role, message))
                }

        }
}