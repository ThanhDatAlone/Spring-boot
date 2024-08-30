package com.example.demo.service;

import com.example.demo.dao.OrderDao;
import com.example.demo.dao.OrderDetailDao;

import com.example.demo.entity.Oder;
import com.example.demo.entity.OrderDetail;

import com.example.demo.service.impl.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public Oder create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();

        // Chuyển đổi JsonNode thành đối tượng Oder
        Oder order = mapper.convertValue(orderData, Oder.class);
        if (order == null) {
            throw new IllegalArgumentException("Invalid order data");
        }
        orderDao.save(order);

        // Chuyển đổi JsonNode của "orderDetail" thành danh sách OrderDetail
        JsonNode orderDetailNode = orderData.get("orderDetail");
        if (orderDetailNode != null && orderDetailNode.isArray()) {
            TypeReference<List<OrderDetail>> typeRef = new TypeReference<List<OrderDetail>>() {};
            List<OrderDetail> details = mapper.convertValue(orderDetailNode, typeRef)
                    .stream()
                    .peek(d -> d.setOrder(order))
                    .collect(Collectors.toList());
            orderDetailDao.saveAll(details);
        } else {
            // Xử lý trường hợp không có orderDetail hoặc không phải dạng mảng
            throw new IllegalArgumentException("Invalid orderDetail data");
        }

        return order;
    }



    @Override
    public Oder findById(Integer id) {
        return orderDao.findById(id).get();
    }

    @Override
    public List<Oder> finByUsername(String username) {
        return orderDao.findByUsername(username);
    }
}
