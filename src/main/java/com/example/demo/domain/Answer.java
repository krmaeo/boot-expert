package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Answer {
    @Id
    @GeneratedValue
    private int id;

    String answer;
    boolean isCorrect;
    private int questionId;

    public Answer(int id,int questionId, String answer, boolean isCorrect) {
        this.id = id;
        this.questionId = questionId;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }
    @JsonIgnore
    public boolean isCorrect() {
        return isCorrect;
    }

}