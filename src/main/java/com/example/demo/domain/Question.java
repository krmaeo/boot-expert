package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

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
