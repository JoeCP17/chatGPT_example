package com.chatgpt.example.dto.request;

import com.theokanning.openai.completion.CompletionRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GPTCompletionRequest {

  private String model;

  private String prompt;

  private Integer maxToken;


  public static CompletionRequest of(GPTCompletionRequest restRequest) {
    return CompletionRequest.builder()
        .model(restRequest.getModel())
        .prompt(restRequest.getPrompt())
        .maxTokens(restRequest.getMaxToken())
        .build();
  }
}
