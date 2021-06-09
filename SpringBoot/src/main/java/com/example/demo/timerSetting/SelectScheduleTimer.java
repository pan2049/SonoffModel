package com.example.demo.timerSetting;

import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.example.demo.timerTask.SonoffTimerOff;
import com.example.demo.timerTask.SonoffTimerOn;
/**
 * 這裡是設定每當系統開啟時、重啟、有設定新的排程時就會執行之，收尋24小時以內之排程
 * 每次搜尋間隔24小時，將掃描到的排程進行TimerOut的設定
 * 
 * @author Huang Pan
 * @see
 * @since 1.0
 */
@Component
public class SelectScheduleTimer {
	
	private Timer timer;

//	@PostConstruct
//    public void systemStartTimerSet(){
//		timer = new Timer();
//        timer.schedule(new SonoffTimerOn(), 0000, 2000);
//        timer.schedule(new SonoffTimerOff(), 1000, 2000);
//    }
//	
//	@PreDestroy
//	public void systemCloseTimerCancel() { 
//		timer.cancel();
//	}
	
	public void timerReset() {
		timer.cancel();
		try {
			Thread.sleep(4000);
			timer = new Timer();
	        timer.schedule(new SonoffTimerOn(), 0000, 2000);
	        timer.schedule(new SonoffTimerOff(), 1000, 2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
