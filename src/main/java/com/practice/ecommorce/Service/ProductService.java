package com.practice.ecommorce.Service;



import com.practice.ecommorce.Model.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(long id);
    public List<Product> getAllProducts();
}
