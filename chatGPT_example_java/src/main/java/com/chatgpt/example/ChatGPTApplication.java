package com.chatgpt.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChatGPTApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatGPTApplication.class, args);
    }

}
