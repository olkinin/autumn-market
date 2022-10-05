package ru.geekbrains.autumnmarket.repository;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import ru.geekbrains.autumnmarket.products.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1l, "Milk", 150),
                new Product(2l, "Bread", 180),
                new Product(1l, "Tomato", 50)));
    }

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
    }
    public List<Product> allProducts(){
        return products;
    }
}


