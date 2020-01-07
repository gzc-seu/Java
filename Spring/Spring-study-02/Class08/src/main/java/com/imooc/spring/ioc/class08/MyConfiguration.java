package com.imooc.spring.ioc.class08;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value ="com.imooc.spring.ioc.class08")
public class MyConfiguration {

/*  @Bean(value=" ") 指定别名，也可指定多个
    public Bean1 bean1(){
        return new Bean1();
    }*/
}
