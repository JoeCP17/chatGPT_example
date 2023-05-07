package com.chatgpt.example.entity.question;

import com.chatgpt.example.common.BaseEntity;
import com.chatgpt.example.entity.answer.GPTAnswer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "gpt_question")
public class GPTQuestion extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "gpt_question", length = 1500, nullable = false)
  private String question;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "answer_id")
  private GPTAnswer answer;

  public GPTQuestion(String question, GPTAnswer answer) {
    this.question = question;
    this.answer = answer;
  }
}
