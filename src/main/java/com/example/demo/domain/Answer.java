package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/*
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Answer {

    @Id
    @GeneratedValue
    private Integer id;
    private String text;
    private Boolean isCorrect;

    public Answer() {

    }
    public Answer(String text, Boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @JsonIgnore
    public Boolean getCorrect() {
        return isCorrect;
    }

}
 */
@Entity
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

    public int getId() {
        return id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getAnswer() {
        return answer;
    }

    @JsonIgnore
    public boolean isCorrect() {
        return isCorrect;
    }

}