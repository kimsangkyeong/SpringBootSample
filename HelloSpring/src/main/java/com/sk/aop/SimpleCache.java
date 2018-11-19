package com.sk.aop;

import org.springframework.stereotype.Component;

@Component
public class SimpleCache implements Cache {
    private int size;
	@Override
	public void setSize(int size) {
		this.size = size;
		System.out.println("size changed : " + size);
	}

}
