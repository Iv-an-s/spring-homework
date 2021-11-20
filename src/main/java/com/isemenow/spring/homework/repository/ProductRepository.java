package com.isemenow.spring.homework.repository;

import com.isemenow.spring.homework.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Bread", 10),
                new Product(2L, "Milk", 20),
                new Product(3L, "Fish", 30),
                new Product(4L, "Apple", 40),
                new Product(5L, "Cheese", 50)
        ));
    }

    public List<Product> getAllProductsList() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There is no product with such id"));
    }

    public void removeProduct(Long productID) {
        products.removeIf(p -> p.getId().equals(productID));
    }
}
