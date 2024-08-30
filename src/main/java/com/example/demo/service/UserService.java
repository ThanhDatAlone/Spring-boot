package com.example.demo.service;

import com.example.demo.dao.AccountDao;
import com.example.demo.entity.Account;
import com.example.demo.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    AccountDao accountService;
    @Autowired
    PasswordEncoder pe;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Account account = accountService.findById(username).get();
            System.out.println(account.getAuthorities().get(0).getRole().getName());
            String password = account.getPassword(); // Mật khẩu đã được mã hóa
            String[] roles = account.getAuthorities().stream()
                    .map(au -> au.getRole().getId())
                    .collect(Collectors.toList()).toArray(new String[0]);

            System.out.println("Found account: " + account);
            System.out.println("Account password: " + password);
            System.out.println("Account roles: " + Arrays.toString(roles));

            return User.withUsername(username)
                    .password(pe.encode(password)) // Không mã hóa lại mật khẩu
                    .roles(roles).build();

        } catch (Exception e) {
            throw new UsernameNotFoundException(username + " not found", e);
        }
    }
}
