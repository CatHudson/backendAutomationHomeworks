package com.geekbrains.BackendAutomation.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "price")
    Integer price;

    public Product(Long id, String title, Integer price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

}
