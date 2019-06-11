package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    String additional_info;

    public Question(int id, String question_text, String additional_info){
        this.id = id;
        this.question_text = question_text;
        this.additional_info= additional_info;
    }

}
