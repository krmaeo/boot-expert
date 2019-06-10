package com.example.demo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String questionText;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn()
    private List<Answer> answerList;

    public Question() {

    }
    public Question(String questionText, List<Answer> answerList) {
        this.questionText = questionText;
        this.answerList = answerList;
    }

    public Integer getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }
}
