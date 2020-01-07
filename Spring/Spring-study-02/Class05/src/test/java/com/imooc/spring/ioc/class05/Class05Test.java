package com.imooc.spring.ioc.class05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 学习使用spring实例化Bean
 * 1.通过构造方法实例化Bean
 * 2.通过静态方法实例化Bean
 * 3.通过实例方法实例化Bean
 * 4.Bean的别名
 */
public class Class05Test {
    @Test
    public void test(){
        //1.通过构造方法实例化Bean
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        Bean1 bean1 = applicationContext.getBean("bean1", Bean1.class);
        System.out.println("bean1:"+bean1);

        //2.通过静态方法实例化Bean
        Bean2 bean2=applicationContext.getBean("bean2",Bean2.class);
        System.out.println("bean2:"+bean2);

        //3.通过实例方法实例化Bean
        Bean3 bean3=applicationContext.getBean("bean3",Bean3.class);
        System.out.println("bean3:"+bean3);
    }
}
