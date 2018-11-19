package com.sk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sk.service.AccountService;

public class AccountMain {

	public static void main(String[] args) {
		//account-conf.xml 파일로 Context 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("account-conf.xml");
		//context의 getBean()을 이용하여 Service Bean 검색
		AccountService service=context.getBean(AccountService.class);
		
		service.getAccount();

	}

}
