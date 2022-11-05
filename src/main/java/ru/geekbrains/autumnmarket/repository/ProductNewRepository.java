package ru.geekbrains.autumnmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.geekbrains.autumnmarket.products.Product;

import java.util.List;

public interface ProductNewRepository extends JpaRepository<Product, Long> {

  

}
