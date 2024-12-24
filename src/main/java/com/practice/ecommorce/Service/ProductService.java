package com.practice.ecommorce.Service;

import java.util.List;

import com.practice.ecommorce.exceptions.ProductNotFoundException;
import org.springframework.data.domain.Page;

import com.practice.ecommorce.Model.Product;

public interface ProductService {
    public Product getProductById(long id) throws ProductNotFoundException;

    public Page<Product> getAllProducts(int page, int size);

    public Product createProduct(String title, String image, String description, double price, String categoryName);

    public Product updateproductPrice(long id, double price);

    public boolean deleatProduct();

    Product findById(long id);

    List<Product> findByProductTitle(String title);

}
