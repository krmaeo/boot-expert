package com.example.demo.domain;

import javax.persistence.*;

@Entity
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
        //this.isCorrect = isCorrect;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }
// public Boolean getCorrect() {
    //    return isCorrect;
    //}
}
