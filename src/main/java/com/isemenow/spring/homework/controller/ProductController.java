package com.isemenow.spring.homework.controller;

import com.isemenow.spring.homework.service.ProductService;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
}