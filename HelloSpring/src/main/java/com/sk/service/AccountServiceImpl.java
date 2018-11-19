package com.sk.service;

import com.sk.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	AccountRepository repository;
	
	public AccountServiceImpl() {
		super();
	}

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

}
