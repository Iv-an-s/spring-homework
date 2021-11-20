package com.isemenow.spring.homework.service;

import com.isemenow.spring.homework.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
