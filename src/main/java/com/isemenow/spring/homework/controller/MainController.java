package com.isemenow.spring.homework.controller;

import com.isemenow.spring.homework.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private ProductRepository productRepository;

    public MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String showProductsPage(Model model){
        model.addAttribute("products", productRepository.getAllProductsList());
        return "products_page";
    }

}