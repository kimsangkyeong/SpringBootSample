package com.sk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Account getAccountByPhone(String phone);
}
