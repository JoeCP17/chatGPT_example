package com.example.chatgpt_example_kotlin.controller

import com.example.chatgpt_example_kotlin.dto.CompletionChatDTO
import com.example.chatgpt_example_kotlin.dto.CompletionChatResponseDTO
import com.example.chatgpt_example_kotlin.dto.CompletionRequestDTO
import com.example.chatgpt_example_kotlin.dto.CompletionResponseDTO
import com.example.chatgpt_example_kotlin.service.GPTChatService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/chat")
class ChatGPTRestController(
        private val gptChatService: GPTChatService
) {

    @PostMapping("/completion")
    fun completion(
            @RequestBody completionRequestDTO: CompletionRequestDTO
    ): CompletionResponseDTO {
        return gptChatService.completion(completionRequestDTO)
    }

    @PostMapping("/completion/chat")
    fun completionChat(
            @RequestBody completionChatRequestDTO: CompletionChatDTO,
    ): CompletionChatResponseDTO {
        return gptChatService.completionChat(completionChatRequestDTO)
    }
}