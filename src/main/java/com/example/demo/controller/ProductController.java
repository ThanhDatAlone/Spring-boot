package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @RequestMapping ("/product/list")
    public String list(Model model, @RequestParam("cid")Optional<String> cid){
       if(cid.isPresent()){
           List<Product> list=productService.findByCategoryId(cid.get());
           model.addAttribute("items",list);
       }else{
           List<Product> list = productService.findAll();
           model.addAttribute("items",list);
       }
        return "product/list";
    }
    @RequestMapping ("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id")Integer id){
        Product item = productService.findById(id);
        model.addAttribute("item",item);
        return "product/detail";
    }
}
