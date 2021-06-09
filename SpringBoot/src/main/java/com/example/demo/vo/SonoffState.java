package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SonoffState {

	@JsonProperty(value="seq")
	private int seq;
	
	@JsonProperty(value="error")
	private  int error;
	
	@JsonProperty(value="data")
	private SonoffData data;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public SonoffData getData() {
		return data;
	}

	public void setData(SonoffData data) {
		this.data = data;
	}
	
	
}
