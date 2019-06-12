package com.example.demo.domain;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionInfo {
    private List<Question> answeredQuestions;
    private Integer score = 0;

    public void addQuestion(Question question){
        answeredQuestions.add(question);
    }

    public void addScore() {
        score++;
    }

    public SessionInfo() {
        this.answeredQuestions = new ArrayList<>();
    }

    public List<Integer> getAnsweredQuestionsId (){
        List<Integer> answeredQuestionsId = new ArrayList<>();
        for (Question q: answeredQuestions) {
            answeredQuestionsId.add(q.getId());
        }
        return answeredQuestionsId;
    }
}
