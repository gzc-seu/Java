package com.imooc.spring.ioc.class1;

import com.imooc.spring.ioc.class1.car.Audi;
import com.imooc.spring.ioc.class1.car.Buick;
import com.imooc.spring.ioc.class1.human.Human;
import com.imooc.spring.ioc.class1.human.lisi;
import com.imooc.spring.ioc.class1.human.zhangsan;
import org.junit.Before;
import org.junit.Test;

public class Class1Test {
    private IocContainer iocContainer=new IocContainer();
    @Before
    public void before(){
        iocContainer.setBeans(Audi.class,"audi");
        iocContainer.setBeans(Buick.class,"buick");
        iocContainer.setBeans(zhangsan.class,"zhangsan","audi");
        iocContainer.setBeans(lisi.class,"lisi","buick");
    }
    @Test
    public void test(){
        Human zhangsan=(Human)iocContainer.getbean("zhangsan");
        zhangsan.goHome();
        Human lisi=(Human)iocContainer.getbean("lisi");
        lisi.goHome();

    }
}
