package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.DeviceRegularDao;
import com.example.demo.po.DeviceRegular;
import com.example.demo.service.DeviceRegularService;

@Service
public class DeviceRegularServiceImpl implements DeviceRegularService {
	
	@Autowired
	DeviceRegularDao dRDao;
	
	
	public String getDeviceRegular(int year,int month,int date,String time) {
		List<DeviceRegular> dRList = dRDao.selectRegulerByDate(year, month, date);
		for(DeviceRegular deviceRegularBean : dRList) {
			
		}
	}
}
