package com.example.demo.timerTask;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

public class SelectSchedule extends TimerTask{

	@Override
	public void run() {
		/* 先抓現在系統時間 時間格式E yyyy-MM-dd HH:mm:ss */

		String systemTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss E"));
		String timeList[] = systemTime.split(" ");
		String date = timeList[0];
		String time = timeList[1];
		String weekly = timeList[2];
		
		
		
	}
	

}
