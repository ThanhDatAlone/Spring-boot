package com.example.demo.service;

import com.example.demo.dao.CategoryDao;
import com.example.demo.entity.Category;
import com.example.demo.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao cdao;
    @Override
    public List<Category> findAll() {
        return cdao.findAll();
    }
}
