package com.sk.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository {
/*	@Autowired
	private DataSource dataSource;*/

	private JdbcTemplate JdbcTemplate;
	
	@Autowired
	public ProductRepository(DataSource dataSource) {
		JdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void select() {
		System.out.println("select ...");
		int count = JdbcTemplate.queryForObject("select count(*) from product", Integer.class	); 
		System.out.println("select count : " + count);
	}
	public void select1() {
		String name = JdbcTemplate.queryForObject("select name from product where no=10 ", String.class	); 
		System.out.println("select1 name : " + name);
	}
	public void insert() {
		int no=1;
		String name="Phone";
		String sql = "insert into product values(?,?)";
		int rowcount = JdbcTemplate.update(sql, no, name);
		System.out.println(rowcount + "updated....");
	}
}
