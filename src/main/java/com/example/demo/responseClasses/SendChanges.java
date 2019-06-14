package com.example.demo.responseClasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class SendChanges {
    private boolean state;
    private int deviceId;

    public SendChanges(boolean state, int deviceId) {
        this.state = state;
        this.deviceId = deviceId;
    }
}
