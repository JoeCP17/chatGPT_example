package com.chatgpt.example.entity.question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GPTQuestionRepository extends JpaRepository<GPTQuestion, Integer> {

}
