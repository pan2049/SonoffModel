package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.GroupInfoDao;
import com.example.demo.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupInfoDao groupInfoDao;
	
	@Override
	public void test(int gId,String deviceIp) {
		groupInfoDao.setGroupInfo(gId, deviceIp);
	}
}
