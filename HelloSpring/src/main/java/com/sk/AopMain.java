package com.sk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sk.aop.Cache;

public class AopMain {

	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(AopConfiguration.class);
		ApplicationContext context = new ClassPathXmlApplicationContext("aop-conf.xml");
		Cache cache = context.getBean(Cache.class);
		cache.setSize(10);

	}

}
