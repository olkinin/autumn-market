package ru.geekbrains.autumnmarket.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class AuthRequest {

    private String name;
    private String password;
}

