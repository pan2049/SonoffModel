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
@Table(name="group")
@Data
public class Group {

	@Id @Column(name="g_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gId;
	
	@Column(name="group_name")
	private String groupName;
	
	@Column(name="state")
	private String state;
	
}
