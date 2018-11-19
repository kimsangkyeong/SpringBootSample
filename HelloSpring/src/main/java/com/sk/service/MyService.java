package com.sk.service;

import com.sk.repository.AccountRepository;

public class MyService {
   private AccountRepository repository;
   public void setRepository(AccountRepository repo) {
	   this.repository = repo;
   }
}
