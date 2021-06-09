package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.po.Device;

public interface DeviceDao extends JpaRepository<Device, String> {

	@Query(value="SELECT * FROM `device`",nativeQuery = true)
	List<Device> findAllDevice();
	
	@Query(value="SELECT * FROM `device` WHERE `device_id` = ?1",nativeQuery = true)
	Device findDeviceById(String deviceId);
}
