package com.example.chatgpt_example_kotlin.entity.question

import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository : JpaRepository<Question, Long> {
}