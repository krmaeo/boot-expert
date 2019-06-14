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

    public SendChanges checkForChanges() {
        SendChanges sendChanges = null;
        for (DeviceStatusAndId reader : readers) {
            if (reader.getState() == 0) {
                return sendChanges = new SendChanges(true, reader.getDeviceId());
            }
        }
        return new SendChanges(false, 404);
    }
}
