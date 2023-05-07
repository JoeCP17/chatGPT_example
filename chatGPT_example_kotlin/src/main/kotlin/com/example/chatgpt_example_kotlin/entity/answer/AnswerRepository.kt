package com.example.chatgpt_example_kotlin.entity.answer

import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository: JpaRepository<Answer, Long> {
}