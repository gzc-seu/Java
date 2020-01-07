package com.imooc.spring.ioc.class09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyBean {
    private AnotherBean1 anotherBean1;
    private AnotherBean1 anotherBean2;
    @Autowired// 这个表示注入bean
    private AnotherBean1 anotherBean3;
    private List<String> anotherBean1List;

    public List<String> getAnotherBean1List() {
        return anotherBean1List;
    }
    @Autowired
    public void setAnotherBean1List(List<String> anotherBean1List) {
        this.anotherBean1List = anotherBean1List;
    }

    @Autowired
    public void setAnotherBean2(AnotherBean1 anotherBean2) {
        this.anotherBean2 = anotherBean2;
    }

    @Autowired
    public MyBean(AnotherBean1 anotherBean1) {
        this.anotherBean1 = anotherBean1;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "anotherBean1=" + anotherBean1 +
                ", anotherBean2=" + anotherBean2 +
                ", anotherBean3=" + anotherBean3 +
                '}';
    }
}
