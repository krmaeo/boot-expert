package com.example.demo.TimeConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class Milliseconds {
    private Long minutes;
    private Long seconds;

    public Milliseconds(Long passedTime) {
        this.minutes = (passedTime / 1000) / 60;
        this.seconds = (passedTime / 1000) % 60;
    }
}
