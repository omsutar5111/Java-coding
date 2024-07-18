package com.practice.ecommorce.Service;


import com.practice.ecommorce.Model.Category;
import com.practice.ecommorce.Model.Product;
import com.practice.ecommorce.Repositories.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Primary
@Service
public class SelfProductService implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryService categoryService;


    public SelfProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public Product getProductById(long id) {
    	 Product p= findById(id);
    	 return p;
       
//        		productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts() {
      return  productRepository.findAll();
    }


    @Override
    public Product createProduct(String title, String image, String description, double price, String categoryName) {
        // Check if the category already exists
        Category category = categoryService.findByName(categoryName);
        if (category == null) {
            // If the category does not exist, create a new one
            category = categoryService.createCategory(categoryName);
        }

        Product product = new Product();
        product.setDescription(description);
        product.setTitle(title);
        product.setPrice(price);
        product.setImage(image);
        product.setCategory(category); // Set the category

        return productRepository.save(product);
    }



    @Override
    public boolean deleatProduct() {
        return false;
    }

	@Override
	public Product updateproductPrice(long id, double price) {
		// TODO Auto-generated method stub
		Product product=findById(id);
		product.setPrice(price);
		return productRepository.save(product);
	}

	@Override
	public Product findById(long id) {
		// TODO Auto-generated method stub
		Product P=productRepository.findById(id).get();
		return P;
	}

	@Override
	public List<Product> findByProductTitle(String title) {
		// TODO Auto-generated method stub
		return productRepository.findByTitle(title);
	}
}
