package com.example.demo.collback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.vo.DeviceResp;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SurveillanceCallbackImpl implements Callback {

//	@Autowired
//	private DeviceResp dBean;
	
	JSONObject data = new JSONObject();
	
	@Override
	public void onFailure(Call call, IOException e) {
		System.out.println("設備已斷線");
		
		
	}

	@Override
	public void onResponse(Call call, Response response) throws IOException {
		String responseStr = response.body().string();
		System.out.println(responseStr+"****************************1");
		data.put("result", responseStr);
		
	}
	
	public Object getResult() {
		return data.get("result");
	}

}
