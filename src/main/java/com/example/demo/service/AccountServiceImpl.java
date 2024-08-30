package com.example.demo.service;

import com.example.demo.dao.AccountDao;
import com.example.demo.entity.Account;
import com.example.demo.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao adao;
    @Override
    public Account finById(String username) {
        return adao.findById(username).get();
    }
}
