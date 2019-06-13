package com.example.demo.responseClasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class DeviceStatusAndId {
    private Integer deviceId;
    private int state;

    public DeviceStatusAndId(Integer deviceId, int state) {
        this.deviceId = deviceId;
        this.state = state;
    }

}
