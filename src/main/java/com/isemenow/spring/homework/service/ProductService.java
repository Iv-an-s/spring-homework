package com.isemenow.spring.homework.service;

import com.isemenow.spring.homework.model.Product;
import com.isemenow.spring.homework.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProductsList() {
        return productRepository.getAllProductsList();
    }

    public void removeProduct(Long productID) {
        productRepository.removeProduct(productID);
    }

    public void changeCost(Long productID, Integer delta) {
        Product product = productRepository.getProductById(productID);
        Integer cost = product.getCost();
        if ((cost + delta) >= 1) {
            product.setCost(cost + delta);
        }
    }
}
