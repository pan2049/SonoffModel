package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.vo.DeviceId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import net.posick.mDNS.Lookup;
import net.posick.mDNS.Lookup.Domain;
import net.posick.mDNS.MulticastDNSService;

@Controller
public class DeviceScanController {

//	@PostMapping(value="/")
//	public String jsonReader() {
//		try {
//			JsonReader reader = new JsonReader(new InputStreamReader("","UTF-8"));
//			Gson gson = new GsonBuilder().create();
//			reader.beginArray();
//			while(reader.hasNext()) {
//				DeviceId deviceId = gson.fromJson(reader, DeviceId.class);
//			}
//			reader.close();
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	@GetMapping(value="/jdimDnsTestFun")
	public String mDnsTest() throws IOException {
		Lookup lookup = new Lookup(MulticastDNSService.DEFAULT_IPv4_ADDRESS);
                    
		Domain[] domains = lookup.lookupDomains();
		for (Domain domain : domains)
		{
			System.out.println(domain);
		}
		lookup.close();
		return "index";
		}
	}
