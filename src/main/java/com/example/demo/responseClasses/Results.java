package com.example.demo.responseClasses;

import com.example.demo.TimeConverter.Milliseconds;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class Results {
    private Integer score;
    private Milliseconds passedTime;

    public Results(Integer score, Milliseconds passedTime) {
        this.score = score;
        this.passedTime = passedTime;
    }
}
