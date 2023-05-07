package com.example.chatgpt_example_kotlin.entity.question

import com.example.chatgpt_example_kotlin.common.base.BaseEntity
import com.example.chatgpt_example_kotlin.entity.answer.Answer
import javax.persistence.*

@Entity
class Question (
        var question: String? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "author_id")
        var answer : Answer? = null
        ): BaseEntity() {

}