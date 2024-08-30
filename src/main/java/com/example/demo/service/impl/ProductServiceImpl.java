package com.example.demo.service.impl;

import com.example.demo.entity.Product;

import java.util.List;


public interface ProductServiceImpl {
    List<Product> findAll();
    Product findById(Integer id);

    List<Product> findByCategoryId(String cid);

    Product create(Product product);

    Product update(Product product);

   void delete(Integer id);
}
