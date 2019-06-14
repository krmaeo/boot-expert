package com.example.demo.responseClasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class RfIdInfo {
    List<DeviceStatusAndId> readers;

    public RfIdInfo(Map<String, String> devicesMapToList) {
        readers = devicesMapToList.entrySet().stream()
                .map(entry ->new DeviceStatusAndId(Integer.parseInt(entry.getKey()),Integer.parseInt(entry.getValue())))
                .collect(Collectors.toList());
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
