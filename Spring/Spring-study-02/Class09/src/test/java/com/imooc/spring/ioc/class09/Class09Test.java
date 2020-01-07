package com.imooc.spring.ioc.class09;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Class09Test {
    @Test
    public void test(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyConfigruation.class);
        MyBean bean = applicationContext.getBean("myBean", MyBean.class);
        System.out.println(bean);
        for (String s: bean.getAnotherBean1List()) {
            System.out.println(s);
        }
    }
}
