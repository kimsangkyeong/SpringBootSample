package com.sk;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk.dto.AccountDTO;
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
	
	MockMvc mock;

	@Autowired
	ObjectMapper objectMapper;
	
	@Before
	public void setUp() {
		mock=MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void contextLoads() throws Exception {
		AccountDTO account = new AccountDTO();
		account.setPassword("11111");
		account.setPhone("abcde");
		account.setUsername("hong");
		ResultActions resultActions = mock.perform(post("/accounts")
				                              .contentType(MediaType.APPLICATION_JSON)
				                              .contentType(objectMapper.writeValueAsString(account)));
		resultActions.andDo(print());
		resultActions.andExpect(status().isOk()); //HTTP OK 확인
		// json path 를 이용하면 데이터의 속성을 쉽게 비교 가능
		resultActions.andExpect(jsonPath("$.username", is("hong")));
	}

}
