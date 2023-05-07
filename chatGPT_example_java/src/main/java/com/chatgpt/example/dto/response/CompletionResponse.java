package com.chatgpt.example.dto.response;

import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionResult;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompletionResponse {

  private String id;

  private String object;

  private Long created;

  private String model;

  private List<Message> messages;

  private Usage usage;


  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Message {

    private String text;

    private Integer index;

    private String finishReason;

    public static Message of(CompletionChoice choice) {
      return new Message(
          choice.getText(),
          choice.getIndex(),
          choice.getFinish_reason()
      );
    }
  }

  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Usage {

    private Long promptTokens;

    private Long completionTokens;

    private Long totalTokens;

    public static Usage of(com.theokanning.openai.Usage usage) {
      return new Usage(
          usage.getPromptTokens(),
          usage.getCompletionTokens(),
          usage.getTotalTokens()
      );
    }
  }

  public static List<Message> toResponseListBy(List<CompletionChoice> choices) {
    return choices.stream()
        .map(Message::of)
        .collect(Collectors.toList());
  }

  public static CompletionResponse of(CompletionResult result) {
    return new CompletionResponse(
        result.getId(),
        result.getObject(),
        result.getCreated(),
        result.getModel(),
        toResponseListBy(result.getChoices()),
        Usage.of(result.getUsage())
    );
  }
}
