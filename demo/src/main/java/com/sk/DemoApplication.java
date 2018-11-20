package com.sk;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		SampleCall sampleCall = new SampleCall();
		sampleCall.setName("hong");
		String name = sampleCall.getName();
		System.out.println("name : " + name);
		log.debug("lombok");
	}
	
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();    	
    }

}
