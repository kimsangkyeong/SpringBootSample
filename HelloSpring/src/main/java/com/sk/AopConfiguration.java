package com.sk;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.sk.aop")
@EnableAspectJAutoProxy
public class AopConfiguration {

}
