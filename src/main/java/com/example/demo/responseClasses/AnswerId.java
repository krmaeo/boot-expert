package com.example.demo.responseClasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerId {
    private Integer answerId;

    public AnswerId(Integer answerId) {
        this.answerId = answerId;
    }
}
