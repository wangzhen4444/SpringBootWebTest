package com.springbootwebtest004;

import com.springbootwebtest004.ch2.DemoPrototypeService;
import com.springbootwebtest004.ch2.DemoSingletonService;
import com.springbootwebtest004.ch2.ElConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jersey.ResourceConfigCustomizer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Springbootwebtest004Application {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(Springbootwebtest004Application.class, args);
////		UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
////		System.out.println(useFunctionService.SayHello("d1"));
//
//		DemoSingletonService s1 = context.getBean(DemoSingletonService.class);
//		DemoSingletonService s2 =context.getBean(DemoSingletonService.class);
//		DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
//		DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);
//
//		System.out.println("s1 与 s2 是否相等："+s1.equals(s2));
//		System.out.println("p1 与 p2 是否相等："+p1.equals(p2));
//
//		context.close();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);

		ElConfig resourceService = context.getBean(ElConfig.class);
		resourceService.outputResource();
		context.close();
	}

}
