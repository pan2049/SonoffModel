package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageResp {

	@JsonProperty(value="message")
	private String message;
	
	@JsonProperty(value="error")
	private String error;
	
	@JsonProperty(value="state")
	private String state;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
