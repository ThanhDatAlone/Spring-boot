package com.example.demo.RestController;

import com.example.demo.entity.Category;
import com.example.demo.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoritesRestcontroller {
    @Autowired
    CategoryService categoryService;
    @GetMapping()
    public List<Category> getALl(){
        return categoryService.findAll();
    }
}
