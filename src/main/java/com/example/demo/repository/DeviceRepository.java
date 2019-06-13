package com.example.demo.repository;

import com.example.demo.domain.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Integer> {
}
