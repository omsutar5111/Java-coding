package com.practice.ecommorce.Model;

import lombok.Data;

@Data
public class Product {
    private  long id;
    private  String image;
    private String title;
    private double price;
    private  Category category;
    private String description;
}
