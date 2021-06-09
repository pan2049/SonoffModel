package com.example.demo.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Dao.DeviceDao;
import com.example.demo.collback.CallbackImpl;
import com.example.demo.collback.SurveillanceCallbackImpl;
import com.example.demo.connect.SonoffConnect;
import com.example.demo.po.Device;
import com.example.demo.service.DeviceService;
import com.example.demo.service.GroupService;
import com.example.demo.timerSetting.SelectScheduleTimer;
import com.example.demo.timerTask.SonoffTimerOff;
import com.example.demo.timerTask.SonoffTimerOn;
import com.example.demo.vo.DeviceResp;
import com.example.demo.vo.GroupResp;
import com.example.demo.vo.SonoffData;
import com.example.demo.vo.SonoffState;
import com.google.gson.Gson;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
//import okhttp3.RequestBody;
import okhttp3.Response;

@Controller
public class FlagController {
	
	@Autowired
	SonoffConnect soConn;
	
	@Autowired
	GroupService gService;
	
	@Autowired
	DeviceService dService;
	
	@Autowired
	DeviceDao dDao;
	
	@Autowired
	SelectScheduleTimer sSchedule;
	
	
	/*
	 * 	掃描現有之設備
	 * 
	 * */
	@PostMapping(value="/jdiFindDevicesFun")
	@ResponseBody
	public String findDevices() {
		return dService.findAllDevices();
	}
	
	/*
	 * 	設備狀態
	 *
	 * */
	@PostMapping(value="/jdiSurveillanceFun")
	@ResponseBody
	public String surveillance(@RequestBody DeviceResp dResp) {
		List<SonoffData> dataList = new ArrayList<>();
		String ip = dResp.getIp();
		OkHttpClient client = new OkHttpClient();
		Request request = soConn.equipmentMonitoring(ip);
		try {
			Response response = client.newCall(request).execute();
			String result = response.body().string();
			JSONObject jsonObject = new JSONObject(result);
			JSONObject data = (JSONObject) jsonObject.get("data");
			String switchState = data.getString("switch");
			SonoffData sonoffBean = new SonoffData();
			sonoffBean.setSwitchState(switchState);
			dataList.add(sonoffBean);
//			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("設備"+ip+"已斷線");
			SonoffData sonoffBean = new SonoffData();
			sonoffBean.setDeviceid(ip);
			sonoffBean.setMessage("設備"+ip+"已斷線");
			dataList.add(sonoffBean);
		}
		JSONArray jsonArray = new JSONArray(dataList);
		System.out.println(jsonArray.toString());
		return jsonArray.toString();
	}
		
	
	/*
	 * 	設備個別開關
	 * 
	 * */
	@PostMapping(value="/jdiSwitchFun")
	public String switchOnOff(@RequestParam String sIp,@RequestParam String switchState) throws IOException {
		System.out.println(sIp);
		System.out.println(switchState);
		OkHttpClient client = new OkHttpClient();
		Request request = soConn.switchOnOff(sIp, switchState);
		
		Call call = client.newCall(request);
		call.enqueue(new CallbackImpl());
		
		return "index";
	}
	
	/*
	 * 	設備編輯頁
	 * 
	 * */
	
	@GetMapping(value="/jdiDeviceEditPage")
	public String deviceEditPage(@RequestParam String deviceId,Model m) {
		Device dBean = dDao.findDeviceById(deviceId);
		m.addAttribute("deviceId",deviceId);
		m.addAttribute("deviceName",dBean.getDeviceName());
		m.addAttribute("place",dBean.getPlace());
		m.addAttribute("ip",dBean.getIp());
		return "deviceEdit";
	}
	
	/*
	 * 	設備群組建立
	 * 
	 * */
//	@PostMapping(value="/")
//	public String groupSet(@RequestBody GroupResp gResp) {
//		
//		return "index";
//	}
	
	/*
	 * 	設備群組開關
	 * 
	 * */
//	@PostMapping(value="/jdiGroupSetFun")
//	public String groupSwitch(@RequestBody GroupResp gResp) {
//		String groupName = gResp.getGroupName();
//		String [] deviceIds = gResp.getDeviceIds();
//		
//		
//
//		
//		return "index";
//	}
	
	
//	/*
//	 * 	設備計時設定
//	 * 
//	 * */
//	@GetMapping(value="/jdiAutoFun")
//	public String autoSwitch() {
//		timerOn = new Timer();
//		timerOff = new Timer();
//		timerOn.schedule(new SonoffTimerOn(),0000,2000);
//		timerOff.schedule(new SonoffTimerOff(),1000,2000);
//		return "index";
//	}
//	/*
//	 * 	設備計時取消
//	 * 
//	 * */
//	@GetMapping(value="jdiCloseFun")
//	public String closeSwith() {
//		timerOn.cancel();
//		timerOff.cancel();
//		return "index";
//	}
	
	
	/*
	 * ****************************************************************************************
	 * 		test
	 * */
	
	@PostMapping(value="/jdiTestFun")
	public String test() {
		String systemTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss E"));
		String timeList[] = systemTime.split(" ");
		String date = timeList[0];
		String time = timeList[1];
		String weekly = timeList[2];
		System.out.println("date:"+date+",time:"+time+",weekly:"+weekly);
		return "All_Equipment";
	}
	
//	@PostMapping(value="/jdiTest2Fun")
//	@ResponseBody
//	public String test2() {
//		String deviceData = dService.findAllDevices();
//		return deviceData;
//	}
	
	/*
	 * ****************************************************************************************
	 * 		已取消
	 * */
//	public final MediaType JSON = MediaType.get("application/json; charset=utf-8");
//	@PostMapping(value="/jdiTestEwFun")
//	public String flagOff() throws IOException {
//		OkHttpClient client = new OkHttpClient();
//		String json = "{\"action\":\"update\",\"deviceid\":\"10010a9849\",\"apikey\":\"14dfa921-0338-4e31-8b28-b9bbefe5314d\",\"selfApikey\":\"14dfa921-0338-4e31-8b28-b9bbefe5314d\",\"params\":{\"switch\":\"on\"},\"sequence\":\"1623151213343\",\"userAgent\":\"pc_ewelink\"}";
//		RequestBody body = RequestBody.create(JSON,json);
//		Request request = new Request.Builder()
//				.url("http://192.168.1.170:8081/zeroconf/switch")
//				.post(body)
//				.build();
//		
//		Call call = client.newCall(request);
//		call.enqueue(new CallbackImpl());
//		
//		return "index";
//	}
}
