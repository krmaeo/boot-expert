package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

/*
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
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question {

    @Id
    @GeneratedValue
    private int id;

    private String question_text;
    //@ElementCollection
    //private List<Answer> answers;
    String additional_info;

    public Question(int id, String question_text, String additional_info){

        // @Id
        this.id = id;

        this.question_text = question_text;
        //this.answers = answers;
        this.additional_info= additional_info;
    }

    public Question() {
    }

    public int getId(){
        return id;
    }

    public String getQuestion(){
        return question_text;
    }

    /*
    public List<Answer> getAnswers() {
        return answers;
    }
     */

    public String getAdditionalInfo() {
        return additional_info;
    }
}
