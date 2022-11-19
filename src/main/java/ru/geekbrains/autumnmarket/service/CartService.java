package ru.geekbrains.autumnmarket.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.autumnmarket.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private ProductService productServtice;
    private List<Optional<Product>> products=new ArrayList<Optional<Product>>();

    public List<Optional<Product>> addProductInTheCart(Optional<Product> product){
        products.add(product);
        return products;
    }
}
