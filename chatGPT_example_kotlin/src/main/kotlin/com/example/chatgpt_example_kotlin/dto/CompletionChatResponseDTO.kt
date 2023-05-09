package com.example.chatgpt_example_kotlin.dto

import com.theokanning.openai.Usage
import com.theokanning.openai.completion.chat.ChatCompletionChoice
import com.theokanning.openai.completion.chat.ChatCompletionResult
import com.theokanning.openai.completion.chat.ChatMessage

data class CompletionChatResponseDTO (
        val id: String,
        val `object`: String,
        val created: Long,
        val model: String,
        val messages: List<Message>,
        val usage: Usage
        ){

    data class Message(
            val role: String,
            val message: String
            ){

        companion object {
            fun makeMessageFrom(chatMessage: ChatMessage): Message {
                return Message(chatMessage.role, chatMessage.content)
            }

            fun toResponseMessagesBy(choices: List<ChatCompletionChoice>): List<Message> {
                return choices.stream()
                        .map { makeMessageFrom(it.message) }
                        .toList()
            }
        }
    }

    companion object {
        fun of(result: ChatCompletionResult): CompletionChatResponseDTO {
            return CompletionChatResponseDTO(
                    id = result.id,
                    `object` = result.`object`,
                    created = result.created,
                    model = result.model,
                    messages = Message.toResponseMessagesBy(result.choices),
                    usage = result.usage
            )
        }
    }
}