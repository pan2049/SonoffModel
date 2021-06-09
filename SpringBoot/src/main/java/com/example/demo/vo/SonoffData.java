package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SonoffData extends MessageResp{

	@JsonProperty(value="switch")
	private String switchState;
	
	@JsonProperty(value="startup")
	private String startup;
	
	@JsonProperty(value="pulse")
	private String pulse;
	
	@JsonProperty(value="pulseWidth")
	private int pulseWidth;
	
	@JsonProperty(value="ssid")
	private String ssid;
	
	@JsonProperty(value="otaUnlock")
	private boolean otaUnlock;
	
	@JsonProperty(value="fwVersion")
	private String fwVersion;
	
	@JsonProperty(value="deviceid")
	private String deviceid;
	
	@JsonProperty(value="bssid")
	private String bssid;
	
	@JsonProperty(value="signalStrength")
	private int signalStrength;

	public String getSwitchState() {
		return switchState;
	}

	public void setSwitchState(String switchState) {
		this.switchState = switchState;
	}

	public String getStartup() {
		return startup;
	}

	public void setStartup(String startup) {
		this.startup = startup;
	}

	public String getPulse() {
		return pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

	public int getPulseWidth() {
		return pulseWidth;
	}

	public void setPulseWidth(int pulseWidth) {
		this.pulseWidth = pulseWidth;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public boolean isOtaUnlock() {
		return otaUnlock;
	}

	public void setOtaUnlock(boolean otaUnlock) {
		this.otaUnlock = otaUnlock;
	}

	public String getFwVersion() {
		return fwVersion;
	}

	public void setFwVersion(String fwVersion) {
		this.fwVersion = fwVersion;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getBssid() {
		return bssid;
	}

	public void setBssid(String bssid) {
		this.bssid = bssid;
	}

	public int getSignalStrength() {
		return signalStrength;
	}

	public void setSignalStrength(int signalStrength) {
		this.signalStrength = signalStrength;
	}
	
	
	
}
