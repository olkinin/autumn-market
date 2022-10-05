package ru.geekbrains.autumnmarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.autumnmarket.products.Product;
import ru.geekbrains.autumnmarket.service.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ProductService productService;

    @GetMapping("/page")

    private String page(Model model) {
        model.addAttribute("productList", productService.allProduct());
        return "productAll.html";
    }

    @GetMapping("/product")

    public String productById(Model model, @RequestParam Long id) {
        model.addAttribute("productById", productService.getProduct(id));
        return "index.html";
    }
}
