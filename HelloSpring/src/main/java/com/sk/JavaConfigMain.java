package com.sk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sk.service.AccountService;

public class JavaConfigMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		AccountService service = context.getBean(AccountService.class);
		service.getAccount();
	}

}
