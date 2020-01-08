package com.gzc.dao.impl;

import com.gzc.dao.IAccountDao;
import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl implements IAccountDao {
    public  void saveAccount(){
        System.out.println("保存了账户");
    }
}
