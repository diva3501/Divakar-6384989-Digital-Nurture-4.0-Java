package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void demoQueries() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Containing 'Phone': " + repository.findByNameContaining("Phone"));
        System.out.println("Starting with 'Lap': " + repository.findByNameStartingWith("Lap"));
        System.out.println("Top 3 Expensive: " + repository.findTop3ByOrderByPriceDesc());
        System.out.println("Price > 25000: " + repository.findByPriceGreaterThan(25000.0));
        System.out.println("Price < 30000: " + repository.findByPriceLessThan(30000.0));
        System.out.println("Created between 2024-01-01 and 2024-12-31: " +
                repository.findByCreatedDateBetween(sdf.parse("2024-01-01"), sdf.parse("2024-12-31")));
    }
}
