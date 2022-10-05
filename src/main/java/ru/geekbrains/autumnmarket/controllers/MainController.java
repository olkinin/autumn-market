package ru.geekbrains.autumnmarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.autumnmarket.products.Product;
import ru.geekbrains.autumnmarket.repository.ProductRepository;
import ru.geekbrains.autumnmarket.service.ProductService;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository repository;

    @GetMapping("/allProduct")

    private List<Product> allProduct() {
        return repository.allProducts();
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product) {
        repository.addProduct(product);
    }

    @PostMapping("/add")
    @ResponseBody
       public void add(Long id, String title, int cost) {
        repository.add(id, title, cost);
    }
}