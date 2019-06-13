package com.example.demo.responseClasses;

import com.example.demo.domain.Answer;
import com.example.demo.domain.Question;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class GetQuestionResponse {
    private Question question;
    private List<Answer> answerList;

    public GetQuestionResponse(Question question, List<Answer> answersList) {
        this.question = question;
        this.answerList = answersList;
    }
}
