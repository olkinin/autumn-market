package ru.geekbrains.autumnmarket.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table (name="roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name="name")
    private String name;


}
