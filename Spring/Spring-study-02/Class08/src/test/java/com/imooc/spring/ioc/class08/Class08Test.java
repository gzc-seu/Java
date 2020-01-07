package com.imooc.spring.ioc.class08;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Class08Test {
    @Test
    public void test(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyConfiguration.class);
        Bean1 bean1 = applicationContext.getBean("bean1", Bean1.class);
        System.out.println(bean1);
    }
}
