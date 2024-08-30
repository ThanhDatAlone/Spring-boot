package com.example.demo.service;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;
import com.example.demo.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceImpl {
    @Autowired
    ProductDao pdao;

    @Override
    public List<Product> findAll() {
        return pdao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return pdao.findById(id).get();
    }

    @Override
    public List<Product> findByCategoryId(String cid) {
        return pdao.findByCategoryId(cid);
    }

    @Override
    public Product create(Product product) {
        return pdao.save(product);
    }

    @Override
    public Product update(Product product) {
        return pdao.save(product);
    }

    @Override
    public void delete(Integer id) {
         pdao.deleteById(id);
    }
}
