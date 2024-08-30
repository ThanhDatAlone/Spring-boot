package com.example.demo.service.impl;


import com.example.demo.entity.Account;
import org.springframework.stereotype.Repository;

public interface AccountService  {
    Account finById(String username);
}
