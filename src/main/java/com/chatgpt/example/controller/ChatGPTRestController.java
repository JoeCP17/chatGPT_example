package com.chatgpt.example.controller;

import com.chatgpt.example.dto.request.GPTCompletionChatRequest;
import com.chatgpt.example.dto.response.CompletionChatResponse;
import com.chatgpt.example.dto.response.CompletionResponse;
import com.chatgpt.example.dto.request.GPTCompletionRequest;
import com.chatgpt.example.service.GPTChatRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chatgpt/rest")
@RequiredArgsConstructor
public class ChatGPTRestController {

  private final GPTChatRestService gptChatRestService;

  @PostMapping("/completion")
  public CompletionResponse completion(final @RequestBody GPTCompletionRequest gptCompletionRequest) {

    return gptChatRestService.completion(gptCompletionRequest);
  }

  @PostMapping("/completion/chat")
  public CompletionChatResponse completionChat(final @RequestBody GPTCompletionChatRequest gptCompletionChatRequest) {

    return gptChatRestService.completionChat(gptCompletionChatRequest);
  }

}
