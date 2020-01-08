package com.gzc.service.impl;

import com.gzc.dao.IAccountDao;
import com.gzc.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao ;

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
