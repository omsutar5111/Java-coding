package com.practice.ecommorce.Service;


import com.practice.ecommorce.Model.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(long id);

    public List<Product> getAllProducts();

    public Product createProduct(String title, String image, String description, double price, String categoryName);

    public Product updateproductPrice(long id,double price);

    public boolean deleatProduct();
    
    Product findById(long id);
    
    List<Product> findByProductTitle(String title);

}
