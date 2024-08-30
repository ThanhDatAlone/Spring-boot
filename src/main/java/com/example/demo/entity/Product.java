package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Product")
public class Product {
    @Id
    private Integer id;
    private String name;
    private String image;
    private BigDecimal price;
    private Date createDate;
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
