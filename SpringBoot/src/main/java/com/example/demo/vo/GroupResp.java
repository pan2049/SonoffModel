package com.example.demo.vo;


import com.fasterxml.jackson.annotation.JsonProperty;

public class GroupResp extends MessageResp{

	@JsonProperty(value="gId")
	private int gId;
	
	@JsonProperty(value="groupName")
	private String groupName;
	
	@JsonProperty(value="deviceIds")
	private String[] deviceIds;
	
	@JsonProperty(value="state")
	private String state;

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String[] getDeviceIds() {
		return deviceIds;
	}

	public void setDeviceId(String[] deviceIds) {
		this.deviceIds = deviceIds;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
