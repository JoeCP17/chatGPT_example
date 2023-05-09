package com.example.chatgpt_example_kotlin.common.config

import com.theokanning.openai.service.OpenAiService
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Slf4j
@Configuration
class ChatGPTConfig {

    @Value("\${gpt.token}")
    private val apiKey: String? = null

    @Bean
    fun openAiService() : OpenAiService {
        return OpenAiService(apiKey!!)
    }
}