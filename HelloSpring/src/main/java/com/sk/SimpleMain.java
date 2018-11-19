package com.sk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-conf.xml");
		HelloBean bean = context.getBean(HelloBean.class);
		System.out.println(bean.hello());
		
		Repo repo = context.getBean(Repo.class); // type based로 찾아오기 : 구현체를 자동으로 찾아준다.
		repo.doSomething();
	}
}
