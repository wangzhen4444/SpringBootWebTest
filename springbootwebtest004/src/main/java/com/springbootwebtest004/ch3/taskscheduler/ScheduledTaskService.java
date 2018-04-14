package com.springbootwebtest004.ch3.taskscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000) //1通过@Scheduled 声明该方法是计划任务，使用 fixedRate 属性每隔固定时间执行
	public void reportCurrentTime() {
		System.out.println("每隔五秒执行一次 " + dateFormat.format(new Date()));
	}

	@Scheduled(cron = "0 28 11 ? * *"  ) //2 使用 cron 属性可按照指定时间执行
	public void fixTimeExecution(){
		System.out.println("在指定时间 " + dateFormat.format(new Date())+"执行");
	}

}

