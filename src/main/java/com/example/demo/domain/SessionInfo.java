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
@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionInfo {
    private List<Question> answeredQuestions;

    public void addQuestion(Question question){
        answeredQuestions.add(question);
    }

    public SessionInfo() {
        this.answeredQuestions = new ArrayList<>();
    }
}
