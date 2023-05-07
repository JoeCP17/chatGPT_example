package com.example.chatgpt_example_kotlin.dto

import com.theokanning.openai.completion.CompletionRequest

data class CompletionRequestDTO(
        val model: String,
        val prompt: String,
        val maxToken: Int
) {

    companion object {
        fun toCompletionRequest(request: CompletionRequestDTO): CompletionRequest {
            return CompletionRequest.builder()
                    .model(request.model)
                    .prompt(request.prompt)
                    .maxTokens(request.maxToken)
                    .build()
        }
    }
}