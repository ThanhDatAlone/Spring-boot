package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
     @RequestMapping("/security/login/form")
    public String loginFrom(Model model){
     model.addAttribute("message","Vui lòng đăng nhập");
     return "security/login";
    }

    @RequestMapping("/security/login/success")
    public String loginSuccess(Model model){
         model.addAttribute("message","Đăng nhập thành công");
         return "security/login";
    }

    @RequestMapping("/security/login/error")
    public String loginError(Model model){
         model.addAttribute("message","Sai thoong tin dang nhap");
        return "security/login";
    }
     @RequestMapping("security/unauthoried")
    public String unauthoried(Model model){
        model.addAttribute("message","khong co quyen truy xuat");
         return "security/login";
    }

    @RequestMapping("/security/logoff/success")
    public String logoffSuccess(Model model){
        model.addAttribute("message","ban da dang xuat");
         return "security/login";
    }
}
