package com.example.demo.dao;

import com.example.demo.entity.Oder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Oder,Integer> {
    @Query("SELECT o from  Oder o where o.account.userName=?1")
    List<Oder> findByUsername(String username);

}
