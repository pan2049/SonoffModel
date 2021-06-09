package com.example.demo.collback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CallbackImpl implements Callback {

	@Override
	public void onFailure(Call call, IOException e) {
		System.out.println("連線異常");
	}

	@Override
	public void onResponse(Call call, Response response) throws IOException {
		System.out.println(response.body().string()); 
		
	}

}
