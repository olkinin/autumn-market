package ru.geekbrains.autumnmarket.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.autumnmarket.entity.User;
import ru.geekbrains.autumnmarket.exeption.DataValidationExeption;
import ru.geekbrains.autumnmarket.exeption.ResourceNotFoundExeption;
import ru.geekbrains.autumnmarket.products.Product;
import ru.geekbrains.autumnmarket.service.CartService;
import ru.geekbrains.autumnmarket.service.ProductService;
import ru.geekbrains.autumnmarket.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class MainController {

    private final ProductService productService;
    private final CartService cartService;
    private final UserService userService;


    @GetMapping()
    private List<Product> findAll() {
        return productService.findAll();
    }


    @GetMapping("/{id}")
    private Optional<Product> findById(@PathVariable Long id) {
        return Optional.of(productService.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Product " + id + " not found")));
    }


    @PostMapping()
    public Product addProduct(@RequestBody @Validated Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DataValidationExeption(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
        }
        productService.save(product);
        return product;
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product) {
        productService.save(product);
        return product;
    }


    @GetMapping("/addCart/{id}")
    private List<Optional<Product>> addCart(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        return cartService.addProductInTheCart(product);

    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable Long id) {
        productService.deleteById(id);

    }
//    @GetMapping("/users")
//    public List<User> findAllUsers(){
//        return userService.findAllUsers();
//    }


}