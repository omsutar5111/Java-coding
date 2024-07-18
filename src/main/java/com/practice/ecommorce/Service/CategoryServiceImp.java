package com.practice.ecommorce.Service;

import com.practice.ecommorce.Model.Category;
import com.practice.ecommorce.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp implements CategoryService {
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
