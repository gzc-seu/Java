package com.imooc.spring.class2;

import com.imooc.spring.ioc.class2.Bean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class2Test {
    @Test
    public void test(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        Bean bean = applicationContext.getBean("bean", Bean.class);
        System.out.println(bean);
    }
}
