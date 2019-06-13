package com.example.demo.responseClasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class RfidInfo {
    private Integer deviceId;
    private int state;

    public RfidInfo(Integer deviceId, int state) {
        this.deviceId = deviceId;
        this.state = state;
    }

}
