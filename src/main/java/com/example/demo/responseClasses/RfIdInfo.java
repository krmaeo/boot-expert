package com.example.demo.responseClasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class RfIdInfo {
    List<DeviceStatusAndId> readers;

    public RfIdInfo(List<DeviceStatusAndId> readers) {
        this.readers = readers;
    }
}
