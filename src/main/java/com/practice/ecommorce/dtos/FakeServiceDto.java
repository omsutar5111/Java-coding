package com.practice.ecommorce.dtos;

import lombok.Data;

@Data
public class FakeServiceDto {
    private  long id;
    private  String image;
    private String title;
    private double price;
    private String category;
    private String description;
}
