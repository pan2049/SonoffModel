package com.example.demo.po;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="group_switch")
@Data
public class GroupSwitch {

	@Id @Column(name="s_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sId;
	
	@Column(name="g_id")
	private int gId;
	
	@Column(name="on_time")
	private Timestamp onTime;
	
	@Column(name="off_time")
	private Timestamp offTime;
}
