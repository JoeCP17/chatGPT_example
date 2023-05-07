package com.example.chatgpt_example_kotlin.service

import com.example.chatgpt_example_kotlin.dto.CompletionRequestDTO
import com.example.chatgpt_example_kotlin.dto.CompletionResponseDTO
import com.example.chatgpt_example_kotlin.entity.answer.Answer
import com.example.chatgpt_example_kotlin.entity.answer.AnswerRepository
import com.example.chatgpt_example_kotlin.entity.question.Question
import com.example.chatgpt_example_kotlin.entity.question.QuestionRepository
import com.theokanning.openai.service.OpenAiService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
@Transactional(readOnly = true)
class GPTChatService(
        private val openAiService: OpenAiService,
        private val questionRepository: QuestionRepository,
        private val answerRepository: AnswerRepository
) {

    @Transactional
    fun completion(completionRequestDTO: CompletionRequestDTO): CompletionResponseDTO {
        val completionResult = openAiService.createCompletion(CompletionRequestDTO.toCompletionRequest(completionRequestDTO))
        val response = CompletionResponseDTO.toDTO(completionResult)

        val messages = response.choices.stream()
                .map { it.text }
                .collect(Collectors.toList())

        val saveAnswer = saveAnswer(messages)
        saveQuestion(completionRequestDTO.prompt, saveAnswer)

        return response
    }


    private fun saveAnswer(answerList: List<String>): Answer {
        val answer = answerList.stream().collect(Collectors.joining())

        return answerRepository.save(Answer(answer = answer))
    }

    private fun saveQuestion(question: String, answerEntity: Answer) {
        questionRepository.save(Question(question = question, answer = answerEntity))
    }
}