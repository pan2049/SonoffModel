package com.example.demo.connect;

import org.springframework.stereotype.Service;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

@Service
public class SonoffConnect {

	public final MediaType JSON = MediaType.get("application/json; charset=utf-8");
	
	/*
	 * 	設備開關ON/OFF
	 * 
	 * */
	public Request switchOnOff(String sIp,String switchState) {
		String json = "{\r\n" + 
				"    \"deviceid\": \"\",\r\n" + 
				"    \"data\": {\r\n" + 
				"        \"switch\": \""+switchState+"\"\r\n" + 
				"    }\r\n" + 
				"}";
		RequestBody body = RequestBody.create(JSON,json);
		Request request = new Request.Builder()
				.url("http://"+sIp+":8081/zeroconf/switch")
				.post(body)
				.build();
		return request;
	}
	
	/*
	 * 	掃描所有設備狀態
	 * 
	 * */
	public Request equipmentMonitoring(String sIp) {
		String json = "{\r\n"
				+ "    \"deviceid\": \"\",\r\n"
				+ "    \"data\": {}\r\n"
				+ "}";
		RequestBody body = RequestBody.create(JSON,json);
		Request request = new Request.Builder()
				.url("http://"+sIp+":8081/zeroconf/info")
				.post(body)
				.build();
		return request;
	}
	
	
}
