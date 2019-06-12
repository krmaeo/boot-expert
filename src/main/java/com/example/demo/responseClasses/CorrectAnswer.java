package com.example.demo.responseClasses;

import com.example.demo.domain.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class CorrectAnswer {

    private Question question;
    private Boolean isCorrect;
    private Integer correctAnswerID;
    private String additionalInfo;

    public CorrectAnswer(Question question,String additionalInfo) {
        this.question = question;
        // This constructor is always called, when the submitted answer is true.
        this.isCorrect = true;
        this.additionalInfo = additionalInfo;
    }

    public CorrectAnswer(Question question, Integer correctAnswerID, String additionalInfo) {
        this.question = question;
        this.correctAnswerID = correctAnswerID;
        // This constructor is always called, when the submitted answer is false.
        this.isCorrect = false;
        this.additionalInfo = additionalInfo;
    }

    @JsonIgnore
    public Question getQuestion() {
        return question;
    }
}
