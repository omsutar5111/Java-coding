package com.practice.ecommorce.Controller;

import java.util.List;

import com.practice.ecommorce.exceptions.ProductNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.ecommorce.Model.Product;
import com.practice.ecommorce.Service.ProductService;
import com.practice.ecommorce.components.AuthUtils;
import com.practice.ecommorce.dtos.CreateProductDto;
import com.practice.ecommorce.dtos.updateProductPriceDto;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private AuthUtils authUtils;
    private static final Logger logger = LogManager.getLogger(ProductController.class);
    @Autowired
    public ProductController(ProductService productService, AuthUtils authUtils) {

        this.productService = productService;
        this.authUtils = authUtils;
    }
    public void doSomething() {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id) throws ProductNotFoundException {

        return productService.getProductById(id);
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getProducts(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "2") int size) {
        Page<Product> products = productService.getAllProducts(page, size);
        logger.info("get all products fetched");
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductDto requestDto,
            @RequestHeader("Auth") String token) {

        if (!authUtils.validateToken(token)) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

        Product product = productService.createProduct(requestDto.getTitle(), requestDto.getImage(),
                requestDto.getDescription(),
                requestDto.getPrice(), requestDto.getCategoryName());
        // return product;

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping
    public Product updatePrice(@RequestBody updateProductPriceDto requestDto) {
        return productService.updateproductPrice(requestDto.getId(), requestDto.getPrice());
    }

    @GetMapping("/title")
    public List<Product> getByTitle(@RequestParam("title") String title) {
        return productService.findByProductTitle(title);
    }
}
