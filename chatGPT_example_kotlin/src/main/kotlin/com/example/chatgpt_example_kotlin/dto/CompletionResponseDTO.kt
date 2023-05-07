package com.example.chatgpt_example_kotlin.dto

import com.theokanning.openai.Usage
import com.theokanning.openai.completion.CompletionChoice
import com.theokanning.openai.completion.CompletionResult

data class CompletionResponseDTO(
        val id: String,
        val oj: String,
        val created: Long,
        val model: String,
        val choices: List<CompletionChoice>,
        val usage: Usage?,
        ) {

        companion object {
                fun toDTO(response: CompletionResult): CompletionResponseDTO {
                        return CompletionResponseDTO(
                                id = response.id,
                                oj = response.`object`,
                                created = response.created,
                                model = response.model,
                                choices = response.choices,
                                usage = response.usage
                        )
                }
        }

}

