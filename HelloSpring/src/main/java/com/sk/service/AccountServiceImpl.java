package com.sk.service;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sk.repository.AccountRepository;

@Component
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository repository;
	
	public void init() {
		System.out.println("init....");
	}
	public AccountServiceImpl() {
		super();
	}
    //@Autowired
	public AccountServiceImpl(AccountRepository repository) {
    	this.repository = repository;
	}

	@Override
	public void getAccount() {
		// TODO Auto-generated method stub
		String account = repository.getAccount();
		System.out.println("AccountServiceImpl. Account : " + account);
		
	}

	@Override
	public void setAccountRepository(AccountRepository repo) {
		// TODO Auto-generated method stub
		this.repository = repo;
	}
    @PreDestroy
    public void destroy() {
    	System.out.println("serviceimpl cleanup ....");
    }
}
