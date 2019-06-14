package com.example.demo.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.NoResultException;

@ControllerAdvice
public class AnyExceptionHandler {
    @ExceptionHandler(NoResultException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFoundException(final NoNewQuestionException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, "No more questions");
    }

    @ExceptionHandler(NoResponseFromDevices.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse NoResponseFromDevices(final NoResponseFromDevices exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, "No changes from devices yet");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse exceptionHandler(Exception e) {
        System.out.println(e);
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
    }
}
