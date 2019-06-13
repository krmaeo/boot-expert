package com.example.demo.responseClasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Info {
    List<RfidInfo> readers;

    public Info(List<RfidInfo> readers) {
        this.readers = readers;
    }
}
