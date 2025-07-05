package com.example.demo;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        productRepository.save(new Product("Laptop Dell", 60000.0, sdf.parse("2024-04-15")));
        productRepository.save(new Product("Laptop HP", 55000.0, sdf.parse("2024-05-10")));
        productRepository.save(new Product("Phone Samsung", 30000.0, sdf.parse("2024-06-01")));
        productRepository.save(new Product("Phone iPhone", 90000.0, sdf.parse("2024-01-20")));
        productRepository.save(new Product("Monitor LG", 15000.0, sdf.parse("2024-03-11")));
    }
}
