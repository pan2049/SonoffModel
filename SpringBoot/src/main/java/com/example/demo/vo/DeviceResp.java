package com.example.demo.vo;


import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceResp extends MessageResp{
	
	@JsonProperty(value="deviceId")
	private String deviceId;
	
	@JsonProperty(value="ip")
	private String ip;
	
	@JsonProperty(value="deviceName")
	private String deviceName;
	
	@JsonProperty(value="startup")
	private String startup;
	
	@JsonProperty(value="timer")
	private Integer timer;
	
	@JsonProperty(value="place")
	private String place;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getStartup() {
		return startup;
	}

	public void setStartup(String startup) {
		this.startup = startup;
	}

	public Integer getTimer() {
		return timer;
	}

	public void setTimer(Integer timer) {
		this.timer = timer;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	
	
	
}
