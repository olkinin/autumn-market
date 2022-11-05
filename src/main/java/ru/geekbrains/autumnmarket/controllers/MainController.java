package ru.geekbrains.autumnmarket.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.autumnmarket.exeption.ResourseNotFoundExeption;
import ru.geekbrains.autumnmarket.products.Product;
import ru.geekbrains.autumnmarket.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class MainController {

    private final ProductService productService;


    @GetMapping()
    private List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    private Optional<Product> findById(@PathVariable Long id) {
        return Optional.of(productService.findById(id).orElseThrow(() -> new ResourseNotFoundExeption("Product " + id + " not found")));
    }

    @DeleteMapping("/delete/{id}")
    private List<Product> deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return productService.findAll();
    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product) {
        productService.save(product);
        return product;
    }
    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product) {
        productService.save(product);
        return product;
    }
}