package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
}
