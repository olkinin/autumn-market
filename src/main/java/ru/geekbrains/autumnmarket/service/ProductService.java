package ru.geekbrains.autumnmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.autumnmarket.products.Product;
import ru.geekbrains.autumnmarket.repository.ProductNewRepository;
import ru.geekbrains.autumnmarket.repository.ProductRepositoryProxy;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
  private ProductNewRepository repository = new ProductRepositoryProxy();


    public List<Product> findAll() {
        return repository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
    public void deleteById(Long id) { repository.deleteById(id);
    }

    public void save(Product product) {
        repository.save(product);

    }

}