package com.example.demo.dao;

import com.example.demo.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityDao extends JpaRepository<Authority,Integer> {
}
