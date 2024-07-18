package com.practice.ecommorce.Repositories;

import com.practice.ecommorce.Model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

 List<Product> findByTitle(String title);
}
