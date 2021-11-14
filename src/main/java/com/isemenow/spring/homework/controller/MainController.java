package com.isemenow.spring.homework.controller;

import com.isemenow.spring.homework.model.Product;
import com.isemenow.spring.homework.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    private final ProductRepository productRepository;

    public MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productRepository.getAllProductsList());
        return "products_page";
    }

    @GetMapping("/products/{id}")
    public String showProductById(Model model, @PathVariable Long id){
        Product product = productRepository.getProductById(id);
        model.addAttribute("product", product);
        return "product_info_page";
    }

}