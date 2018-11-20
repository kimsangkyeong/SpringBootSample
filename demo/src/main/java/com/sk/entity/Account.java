package com.sk.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Account {
	@Id@GeneratedValue
	private Long id;
	
	private String username;
	private String password;
	
	@Column(unique=true)
	private String phone;  //for unique check
	
	private Date joined;
}
