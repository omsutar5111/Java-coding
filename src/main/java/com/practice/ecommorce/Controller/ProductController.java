package com.practice.ecommorce.Controller;


import com.practice.ecommorce.Model.Product;
import com.practice.ecommorce.Service.ProductService;
import com.practice.ecommorce.dtos.CreateProductDto;
import com.practice.ecommorce.dtos.updateProductPriceDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id) {

        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getProducts() {

        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody CreateProductDto requestDto) {
        return productService.createProduct(requestDto.getTitle(), requestDto.getImage(), requestDto.getDescription(), requestDto.getPrice(), requestDto.getCategoryName());
//        return product;
    }
    
    @PutMapping
    public Product updatePrice(@RequestBody updateProductPriceDto requestDto ) {
    	return productService.updateproductPrice(requestDto.getId(), requestDto.getPrice());
    }
    
    @GetMapping("/title")
    public List<Product>getByTitle(@RequestParam("title")String title){
    	return productService.findByProductTitle(title);
    }
}
