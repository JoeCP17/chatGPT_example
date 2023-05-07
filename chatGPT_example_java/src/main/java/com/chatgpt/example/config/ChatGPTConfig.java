package com.chatgpt.example.config;

import com.theokanning.openai.service.OpenAiService;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Chat GPT 라이브러리를 사용하기전, 해당 서비스에 토큰 주입을 하기위한 Config
 * API Key 발급은 https://platform.openai.com/account/api-keys 에서 발급받을 수 있습니다.
 */
@Slf4j
@Configuration
public class ChatGPTConfig {

  @Value("${gpt.token}")
  private String token;

  @Bean
  public OpenAiService openAiService() {
    log.info("token : {}을 활용한 OpenAiService 을 생성합니다.", token);
    return new OpenAiService(token, Duration.ofSeconds(60));
  }

}
