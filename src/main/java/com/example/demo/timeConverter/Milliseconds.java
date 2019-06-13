package com.example.demo.timeConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

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
