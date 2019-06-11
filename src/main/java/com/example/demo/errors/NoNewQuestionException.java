package com.example.demo.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoNewQuestionException extends Exception{

    public NoNewQuestionException() {

    }

    public NoNewQuestionException(String errorMessage) {
        super(errorMessage);
    }
}
