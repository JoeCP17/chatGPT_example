package com.chatgpt.example.entity.answer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GPTAnswerRepository extends JpaRepository<GPTAnswer, Integer> {
}
