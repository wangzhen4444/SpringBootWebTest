package com.springbootwebtest004.ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

	//使用onApplicationEvent方法对消息进行接受处理
	public void onApplicationEvent(DemoEvent event) {

		String msg = event.getMsg();

		System.out.println("我(bean-demoListener)接受到了bean-demoPublisher发布的消息:"
				+ msg);

	}

}

