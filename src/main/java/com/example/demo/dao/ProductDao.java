package com.example.demo.dao;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
    @Query("SELECT P FROM Product P WHERE P.category.id=?1")
    List<Product> findByCategoryId(String id);
}
