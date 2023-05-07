package com.example.chatgpt_example_kotlin.entity.answer

import com.example.chatgpt_example_kotlin.common.base.BaseEntity
import javax.persistence.Entity

@Entity
class Answer(
        var answer: String? = null
): BaseEntity() {

    fun update(answer: String) {
        this.answer = answer
    }
}