package com.poly.util;

import java.util.Timer;
import java.util.TimerTask;

public class TaskManager {
	public static Timer timer = null;

	public static String SUCCESS = "success";

	public static String FAIL = "fail";

	public static String startTask(TimerTask tt,int startTime, int time) {

		timer = new Timer();
		timer.schedule(tt, startTime, time);
		return SUCCESS;
	}

	public static String stopTask() {
		if (timer != null) {
			timer.cancel();
			return SUCCESS;
		} else {
			return FAIL;
		}
	}

}
