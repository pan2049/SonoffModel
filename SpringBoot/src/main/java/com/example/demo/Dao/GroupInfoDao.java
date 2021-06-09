package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.po.GroupInfo;


public interface GroupInfoDao extends JpaRepository<GroupInfo,Integer>{

	// INSERT INTO `sonoffdb`.`groupinfo` (`gId`, `deviceIp`) VALUES ('1', '192.168.1.500');
	@Transactional
	@Modifying
	@Query(value="INSERT INTO `groupinfo` (`gId`, `deviceIp`) VALUES (?1, ?2)",nativeQuery = true)
	void setGroupInfo(int gId,String deviceIp);
}
