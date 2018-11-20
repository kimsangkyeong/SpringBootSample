package com.sk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sk.repository.MemberRepository;
import com.sk.repository.ProductRepository;

public class JdbcMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-conf.xml");
		
/*		ProductRepository repository = context.getBean(ProductRepository.class);
		repository.select();
		repository.select1();
		repository.insert();
		repository.select();*/
		MemberRepository repository = context.getBean(MemberRepository.class);
		String name = repository.findMember("hong");
		System.out.println("member : " + name);
	}

}
