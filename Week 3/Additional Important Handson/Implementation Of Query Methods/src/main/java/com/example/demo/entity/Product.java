package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    
    public Product() {}

    public Product(String name, Double price, Date createdDate) {
        this.name = name;
        this.price = price;
        this.createdDate = createdDate;
    }

    
    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public Date getCreatedDate() { return createdDate; }

    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", createdDate=" + createdDate + "]";
    }
}
