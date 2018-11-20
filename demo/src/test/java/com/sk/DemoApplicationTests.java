package com.sk;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.sk.service.AccountService;

@RunWith(SpringRunner.class)
//@SpringBootTest
@ContextConfiguration(loader=SpringBootContextLoader.class, classes=DemoApplication.class)
@WebAppConfiguration
@Transactional
public class DemoApplicationTests {
	@Autowired
	WebApplicationContext wac;
	@Autowired
	AccountService service;
	
	
	@Test
	public void contextLoads() {
	}

}
