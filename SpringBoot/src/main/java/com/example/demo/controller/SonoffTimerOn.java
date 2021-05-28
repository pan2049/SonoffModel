package com.example.demo.controller;

import java.io.IOException;
import java.util.TimerTask;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SonoffTimerOn extends TimerTask{

	public final MediaType JSON = MediaType.get("application/json; charset=utf-8");
	@Override
	public void run() {
		System.out.println("On");
		OkHttpClient client = new OkHttpClient();
		String json = "{\r\n" + 
				"    \"deviceid\": \"\",\r\n" + 
				"    \"data\": {\r\n" + 
				"        \"switch\": \"on\"\r\n" + 
				"    }\r\n" + 
				"}";
		RequestBody body = RequestBody.create(JSON,json);
		Request request = new Request.Builder()
				.url("http://192.168.1.114:8081/zeroconf/switch")
				.post(body)
				.build();
		
		try(Response response = client.newCall(request).execute()){
			System.out.println(response.body().string()); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
