package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.DeviceDao;
import com.example.demo.po.Device;
import com.example.demo.service.DeviceService;
import com.example.demo.vo.DeviceResp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	DeviceDao dDao;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Override
	public String findAllDevices() {
		List<Device> dList = dDao.findAllDevice();
		try {
			String dJson = objectMapper.writeValueAsString(dList);
			System.out.println(dJson);
			return dJson;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			DeviceResp dResp = new DeviceResp();
			dResp.setMessage("Json 處理異常");
			List<DeviceResp> msgList = new ArrayList<>();
			msgList.add(dResp);
			JSONArray msgArr = new JSONArray(msgList);
			return msgArr.toString();
		}
	}
}
