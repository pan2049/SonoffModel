package com.example.demo.controller;

import java.io.IOException;
import java.util.Timer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Controller
public class FlagController {

	public final MediaType JSON = MediaType.get("application/json; charset=utf-8");
//	@Autowired
//	OkHttpClient client;
	
	@GetMapping(value="/jdiFlagOnFun")
	public String flagOn(@RequestParam int sIp) throws IOException {
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
				.url("http://192.168.1."+sIp+":8081/zeroconf/switch")
				.post(body)
				.build();
		
		Call call = client.newCall(request);
		call.enqueue(new CallbackImpl());
		
		return "index";
	}
	
	@GetMapping(value="/jdiFlagOffFun")
	public String flagOff(@RequestParam int sIp) throws IOException {
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
				.url("http://192.168.1."+sIp+":8081/zeroconf/switch")
				.post(body)
				.build();
		
		Call call = client.newCall(request);
		call.enqueue(new CallbackImpl());
		
		return "index";
	}
	
	@GetMapping(value="/jdiAutoFun")
	public String autoSwitch() {
		Timer timerOn = new Timer();
		timerOn.schedule(new SonoffTimerOn(),0000,2000);
		Timer timerOff = new Timer();
		timerOff.schedule(new SonoffTimerOff(),1000,2000);
		return "index";
	}
	
}
