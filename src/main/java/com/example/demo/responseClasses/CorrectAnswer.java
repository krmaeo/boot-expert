package com.example.demo.responseClasses;

import com.example.demo.domain.Answer;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class CorrectAnswer {

    private Answer answer;
    private String additionalInfo;

    public CorrectAnswer(Answer answer, String additionalInfo) {
        this.answer = answer;
        this.additionalInfo = additionalInfo;
    }
}
