package com.example.demo.controller;

import com.example.demo.dao.ProductDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {


    @RequestMapping({"/","/home/index"})
    public String home(){
        return "redirect:/product/list";
    }

    @RequestMapping({"/admin","/admin/home/index"})
    public String admin(){
        return "redirect:/assets/admin/index.html";
    }


}
