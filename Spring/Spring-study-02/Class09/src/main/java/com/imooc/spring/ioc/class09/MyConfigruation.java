package com.imooc.spring.ioc.class09;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("com.imooc.spring.ioc.class09")
public class MyConfigruation {
    @Bean
    public List<String> stringlist(){
        List<String> list=new ArrayList<>();
        list.add("111");
        list.add("222");
        return list;
    }
}
