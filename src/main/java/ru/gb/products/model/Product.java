package ru.gb.products.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    private long id;

    private String title;

    private float price;
}
