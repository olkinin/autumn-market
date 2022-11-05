package ru.geekbrains.autumnmarket.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.autumnmarket.products.Product;
import ru.geekbrains.autumnmarket.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController

public class MainController {
    @Autowired
    private ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    private List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    private Optional<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/products/delete/{id}")
    private List<Product> deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return productService.findAll();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
       productService.save(product);
       return product;
    }
}