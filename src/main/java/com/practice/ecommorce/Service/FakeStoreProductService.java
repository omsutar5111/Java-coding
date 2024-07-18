package com.practice.ecommorce.Service;


import com.practice.ecommorce.Model.Category;
import com.practice.ecommorce.Model.Product;
import com.practice.ecommorce.dtos.FakeServiceDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Data

@Service("fakestore")
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;
    private WebClient webClient;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate, WebClient webClient) {
        this.restTemplate = restTemplate;
        this.webClient = webClient;
    }

    private Product ConvertFakeServiceDtoToProduct(FakeServiceDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());
        product.setDescription(dto.getDescription());
        Category category = new Category();
        category.setName(dto.getCategory());
//        product.setCategory(category);
        return product;
    }

    @Override
    public Product getProductById(long id) {
//        RestTemplate restTemplate=new RestTemplate();
        try {
            FakeServiceDto product = this.restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeServiceDto.class);
            return ConvertFakeServiceDtoToProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Product> getAllProducts() {

        //WebClient webClient = WebClient.create(); // get WeClient instance
        try {
            Object obj = webClient.get() // represents HTTP GET request
                    .uri("https://fakestoreapi.com/products")
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(Object.class)
                    .block();

            List<Product> p = (List<Product>) obj;

            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

    @Override
    public Product createProduct(String title, String image, String description, double price, String categoryName) {
        return null;
    }

  

    @Override
    public boolean deleatProduct() {
        return false;
    }

	@Override
	public Product updateproductPrice(long id, double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByProductTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}
}
