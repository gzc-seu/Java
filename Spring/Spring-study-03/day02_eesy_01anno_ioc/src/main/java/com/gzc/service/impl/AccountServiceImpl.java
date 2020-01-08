package com.gzc.service.impl;

import com.gzc.dao.IAccountDao;
import com.gzc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//<bean id="accountService" class="com.gzc.service.impl.AccountServiceImpl"></bean>
@Component
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao=null ;

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
