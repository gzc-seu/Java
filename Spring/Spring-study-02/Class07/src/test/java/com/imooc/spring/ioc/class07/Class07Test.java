package com.imooc.spring.ioc.class07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class07Test {
    @Test
    public void test(){
        /**
         * Spring容器会在创建容器时提前初始化Singleton作用域的bean。
         * 但是如果Bean被标注了lazy-init=true，则该Bean只有在被需要时才初始化，即为Bean的懒加载
         * 注意：只对Singleton作用域的bean有效
         *
         * 懒加载优点：节省资源
         * 缺点：可能会导致某个操作响应时间增加
         */
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("context已经被创建");
        Bean bean = applicationContext.getBean("bean", Bean.class);
        System.out.println(bean);
    }
}
