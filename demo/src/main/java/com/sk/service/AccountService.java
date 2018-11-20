package com.sk.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.dto.AccountDTO;
import com.sk.entity.Account;
import com.sk.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository repository;
	
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
	  // repository.getAccounts();	
		return repository.findAll();
	}

	public Account createAccount(AccountDTO newAccount) {
		// TODO Auto-generated method stub
		Account account = new Account();
		Date now = new Date();
		BeanUtils.copyProperties(newAccount, account);
		account.setJoined(now);
		return repository.save(account);
	}

	public Account findAccount(Long id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	public void deleteAccount(Long id) {
		// TODO Auto-generated method stub
		repository.delete(id);
	}

	public Account findAccountByPhone(String phone) {
		// TODO Auto-generated method stub
		return repository.getAccountByPhone(phone);
	}

}
