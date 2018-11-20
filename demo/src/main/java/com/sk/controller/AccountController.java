package com.sk.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sk.dto.AccountDTO;
import com.sk.entity.Account;
import com.sk.entity.ResponseAccount;
import com.sk.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	AccountService service;
	@Autowired
	ModelMapper mapper;
	
	@RequestMapping(value="/accounts", method=RequestMethod.GET)
	public ResponseEntity getAccount() {
		List<Account> accounts;
		System.out.println("/accounts called by GET");
		accounts = service.getAccounts();
		System.out.println(null==accounts);
		return null;
	}
	@RequestMapping(value="/accounts", method=RequestMethod.POST)
	public ResponseEntity createAccount(@Valid AccountDTO newAccount, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("binding error");
		}
		Account account = service.createAccount(newAccount);
		System.out.println("/accounts called by POST !" + newAccount);
		//return new ResponseEntity<>(mapper.map(account, ResponseAccount.class),HttpStatus.OK);	
		return new ResponseEntity<>(account,HttpStatus.OK);
	}
	@RequestMapping(value="/accounts/id/{id}",method=RequestMethod.GET)
	public ResponseEntity findAccount(@PathVariable Long id) {
	    Account account = service.findAccount(id);
		return new ResponseEntity<>(mapper.map(account, ResponseAccount.class),HttpStatus.OK);	
	}
	@RequestMapping(value="/accounts/{id}",method=RequestMethod.DELETE)
	public ResponseEntity deleteAccount(@PathVariable Long id) {
		service.deleteAccount(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
	}
	@RequestMapping(value="/accounts/hp/{phone}",method=RequestMethod.GET)
	public ResponseEntity findAccountByPhone(@PathVariable String phone) {
	    Account account = service.findAccountByPhone(phone);
		return new ResponseEntity<>(mapper.map(account, ResponseAccount.class),HttpStatus.OK);	
	}	
}