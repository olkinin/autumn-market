package ru.geekbrains.autumnmarket.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.autumnmarket.products.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;
//    @Autowired
//    private ProductRepository productRepository

    @PostConstruct
    private void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1l, "Milk", 150),
                new Product(2l, "Bread", 180),
                new Product(3l, "Tomato", 50)));
    }

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
    }

    public List<Product> allProducts() {
        return products;
    }

    public void add(Long id, String title, int cost) {
        products.add(new Product(id, title, cost));
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}




