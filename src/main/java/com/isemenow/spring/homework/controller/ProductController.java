package com.isemenow.spring.homework.controller;

import com.isemenow.spring.homework.model.Product;
import com.isemenow.spring.homework.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProductsList() {
        return productService.getAllProductsList();
    }

    @GetMapping("/products/delete/{productID}")
    public void removeProduct(@PathVariable Long productID) {
        productService.removeProduct(productID);
    }

    @GetMapping("/products/change_cost")
    public void changeCost(@RequestParam Long productID, @RequestParam Integer delta) {
        productService.changeCost(productID, delta);
    }
}