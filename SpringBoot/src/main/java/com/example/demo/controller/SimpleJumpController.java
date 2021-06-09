package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleJumpController {

	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/jdiAllDevicePage")
	public String test() {
		return "All_Equipment";
	}
	
}
