package com.imooc.spring.ioc.class06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class06Test {
    @Test
    public void test(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        Bean bean=applicationContext.getBean("bean",Bean.class);
        System.out.println("bean:"+bean);

        System.out.println("bean.string:"+bean.getStringList());
        System.out.println("bean.string:"+bean.getAnotherBeanList());
        System.out.println("bean.string:"+bean.getStringset());
        System.out.println("bean.string:"+bean.getAnotherBeanset());
        System.out.println("bean.string:"+bean.getStringMap());
        System.out.println("bean.string:"+bean.getAnotherBeanmap());
        System.out.println("bean.string:"+bean.getProperties());
        System.out.println("bean.get:"+bean.getAnotherBean2());
    }
}
