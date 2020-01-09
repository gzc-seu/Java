package com.gzc.test;

import com.gzc.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = (IAccountService)applicationContext.getBean("accountService");
        as.saveAccount();
        as.updateAccount(1);
        as.deleteAccount();
    }
}
