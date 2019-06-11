package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue
    private int id;

    String answer_text;
    boolean is_Correct;
    private int question_Id;

    public Answer(int id,int questionId, String answer, boolean isCorrect) {
        this.id = id;
        this.question_Id = questionId;
        this.answer_text = answer;
        this.is_Correct = isCorrect;
    }

    @JsonIgnore
    public boolean is_Correct() {
        return is_Correct;
    }

}