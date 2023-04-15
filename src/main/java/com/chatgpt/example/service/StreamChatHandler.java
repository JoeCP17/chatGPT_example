package com.chatgpt.example.service;

import com.chatgpt.example.dto.request.GPTCompletionChatRequest;
import com.chatgpt.example.dto.request.GPTCompletionRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theokanning.openai.service.OpenAiService;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
@RequiredArgsConstructor
public class StreamChatHandler extends TextWebSocketHandler {

  private final HashMap<String, WebSocketSession> sessionHashMap;

  private final ObjectMapper objectMapper = new ObjectMapper();

  private final OpenAiService openAiService;

  /* Client가 접속 시 호출되는 메서드 */
  @Override
  public void afterConnectionEstablished(WebSocketSession session) {

    sessionHashMap.put(session.getId(), session);
    log.info("현재 접근한 유저 : {}", session.getId());
  }

  /* Client가 접속 해제 시 호출되는 메서드드 */
  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {

    sessionHashMap.remove(session.getId());
    log.info("연결해제 한 유저 : {}", session.getId());
  }

  @Override
  public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

    GPTCompletionRequest completionRequest = objectMapper.readValue(message.getPayload(),
        GPTCompletionRequest.class);

    sessionHashMap.keySet().forEach(key -> {
      streamCompletion(key, completionRequest);
    });
  }

  private void streamCompletion(String key, GPTCompletionRequest completionRequest) {
    openAiService.streamCompletion(GPTCompletionRequest.of(completionRequest))
        .blockingForEach(completion -> {
          sessionHashMap.get(key).sendMessage(new TextMessage(objectMapper.writeValueAsString(completion)));
        });
  }

}
