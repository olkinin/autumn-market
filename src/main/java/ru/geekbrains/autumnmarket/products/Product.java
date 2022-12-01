package ru.geekbrains.autumnmarket.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Товар должен иметь название")
    @Column(name = "title")
    private String title;

    @Min(value = 1, message = "Цена товара не может быть менее 1 руб.")
    @Column(name = "price")
    private int price;

}

