package com.sk.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MemberRepository {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MemberRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public String findMember(String id) {
		String sql = "select name from member where id = ?";
		return jdbcTemplate.queryForObject(sql, String.class,id);
	}
}
