package ru.geekbrains.autumnmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.autumnmarket.products.Product;
import ru.geekbrains.autumnmarket.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;


    public Product getProduct(Long id) {
        return repository.findById(id);
    }

    public List<Product> allProduct() {
        return repository.allProducts();
    }
}