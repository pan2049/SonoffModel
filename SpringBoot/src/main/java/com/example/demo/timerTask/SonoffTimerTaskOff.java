package com.example.demo.timerTask;

import java.io.IOException;
import java.util.TimerTask;

import com.example.demo.collback.CallbackImpl;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SonoffTimerTaskOff extends TimerTask{

	public final MediaType JSON = MediaType.get("application/json; charset=utf-8");
	@Override
	public void run() {
		System.out.println("Off");
		OkHttpClient client = new OkHttpClient();
		String json = "{\r\n" + 
				"    \"deviceid\": \"\",\r\n" + 
				"    \"data\": {\r\n" + 
				"        \"switch\": \"off\"\r\n" + 
				"    }\r\n" + 
				"}";
		RequestBody body = RequestBody.create(JSON,json);
		Request request = new Request.Builder()
				.url("http://192.168.1.116:8081/zeroconf/switch")
				.post(body)
				.build();
		
		Call call = client.newCall(request);
		call.enqueue(new CallbackImpl());
		
	}
	
	public void stopTimer() {
		super.cancel();
	}

}
