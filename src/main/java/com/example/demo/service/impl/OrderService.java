package com.example.demo.service.impl;

import com.example.demo.entity.Oder;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;


public interface OrderService {
    Oder create(JsonNode orderData);

    Oder findById(Integer id);

    List<Oder> finByUsername(String username);
}
