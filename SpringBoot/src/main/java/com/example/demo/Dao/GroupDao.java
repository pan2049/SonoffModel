package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.po.Group;

public interface GroupDao extends JpaRepository<Group, Integer> {

	
}
