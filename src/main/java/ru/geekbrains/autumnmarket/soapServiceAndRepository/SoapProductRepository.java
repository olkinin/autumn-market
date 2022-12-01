package ru.geekbrains.autumnmarket.soapServiceAndRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.autumnmarket.products.Product;


import java.util.Optional;

@Repository
public interface SoapProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Products p where p.id = ?1")
    Optional<Product> findById(long id);
}

