package com.example.demo.service;

import com.example.demo.domain.Device;
import com.example.demo.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public Device getDeviceById(Integer id) {
        return deviceRepository.findById(id).get();
    }

    public List<Device> getAllDevices() {
        List<Device> devices = new ArrayList<>();
        deviceRepository.findAll().forEach(device -> devices.add(device));
        return devices;
    }

}
