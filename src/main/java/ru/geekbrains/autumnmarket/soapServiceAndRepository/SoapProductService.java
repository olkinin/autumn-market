package ru.geekbrains.autumnmarket.soapServiceAndRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.autumnmarket.products.Product;
import ru.geekbrains.autumnmarket.soap.Products;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SoapProductService {

    private final SoapProductRepository productRepository;

    public static final Function<Product, Products> functionEntityToSoap = product-> {
        Products p = new Products();
        p.setId(product.getId());
        p.setTitle(product.getTitle());
        p.setPrice(product.getPrice());

        return p;
    };

   public List<Products> getAllProducts() {
        return  productRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }

    public Products getById(Long id) {
        return productRepository.findById(id).map(functionEntityToSoap).get();
    }
}


