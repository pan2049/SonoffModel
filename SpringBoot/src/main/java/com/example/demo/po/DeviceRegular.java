package com.example.demo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="device_regular")
@Data
public class DeviceRegular {

	@Id @Column(name="D_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dId;
	
	@Column(name="Site")
	private String site;
	
	@Column(name="YearD")
	private int year;
	
	@Column(name="MonthD")
	private int month;
	
	@Column(name="DateD")
	private int date;
	
	@Column(name="Mon")
	private String mon;
	
	@Column(name="Tues")
	private String tues;
	
	@Column(name="Wed")
	private String wed;
	
	@Column(name="Thurs")
	private String thurs;
	
	@Column(name="Fri")
	private String fri;
	
	@Column(name="Satur")
	private String satur;
	
	@Column(name="Sun")
	private String sun;
	
	@Column(name="DTime")
	private String time;
	
	@Column(name="Status")
	private String status;
}
