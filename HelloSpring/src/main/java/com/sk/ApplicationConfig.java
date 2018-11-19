package com.sk;

import javax.xml.ws.Response;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sk.repository.AccountRepository;
import com.sk.repository.AccountRepositoryImpl;
import com.sk.service.AccountService;
import com.sk.service.AccountServiceImpl;
import com.sk.service.MyService;

@Configuration
//@ComponentScan(basePackages="com.sk.repository,com.sk.service")
public class ApplicationConfig {
	@Bean
	public AccountRepository accountRepository() {
		AccountRepository repository = new AccountRepositoryImpl();
		return repository;
	}
	
	@Bean
	public AccountService accountService() {
		AccountService service = new AccountServiceImpl();
		service.setAccountRepository(accountRepository());
		return service;
	}
	
	@Bean
	public MyService myService() {
		MyService service = new MyService();
		service.setRepository(accountRepository());
		return service;
	}
}
