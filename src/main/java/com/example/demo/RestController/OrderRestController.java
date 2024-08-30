package com.example.demo.RestController;

import com.example.demo.entity.Oder;
import com.example.demo.service.impl.OrderService;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
    @Autowired
    OrderService orderService;
    @PostMapping("")
    public Oder create(@RequestBody JsonNode orderData) {
        return orderService.create(orderData);
    }


}
