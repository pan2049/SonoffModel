package com.example.demo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="group_info")
@Data
public class GroupInfo {
	
	@Column(name="g_id")
	private int gId;
	
	@Column(name="device_id")
	private String deviceId;
	
	@Id @Column(name="f_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fId;	
	

}
