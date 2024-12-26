package com.practice.ecommorce.Repositories;

import java.util.List;
import java.util.Optional;

import com.practice.ecommorce.exceptions.ProductNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.ecommorce.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);



    Page<Product> findAll(Pageable pageable);

//    @Query("select * from ");
//    List<Product> findAllProductsWithProductName(String productName);
}
