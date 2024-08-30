package com.example.demo.controller;

import com.example.demo.entity.Oder;
import com.example.demo.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @RequestMapping("/order/checkout")
    public String checkout(){
        return "order/checkout";
    }
    @RequestMapping("/order/list")
    public String list(Model model, HttpServletRequest request){
       String username = request.getRemoteUser();
       model.addAttribute("orders",orderService.finByUsername(username));


        return "order/list";
    }

    @RequestMapping("/order/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        Oder order = orderService.findById(id);
        if (order != null) {
            model.addAttribute("order", order);
            System.out.println(order.getAccount().getUserName());
            System.out.println(order.getAddress());
            System.out.println(order.getCreateDate());
            System.out.println(order.getId());
        } else {
            // Xử lý trường hợp không tìm thấy đơn hàng
            return "error/404";
        }
        return "order/detail";
    }
}
