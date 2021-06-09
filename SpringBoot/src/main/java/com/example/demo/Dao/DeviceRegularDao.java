package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.po.DeviceRegular;

public interface DeviceRegularDao extends JpaRepository<DeviceRegular, Integer> {

	@Query(value="SELECT * FROM `device_regular` WHERE `YearD` = ?1 AND `MonthD` = ?2 AND `DateD` = ?3",nativeQuery = true)
	List<DeviceRegular> selectRegulerByDate(int year,int month,int date);
}
