package com.practice.ecommorce.Service;

import com.practice.ecommorce.Model.Category;

public interface CategoryService {

    public Category createCategory(String Name);

    Category findByName(String name);
}
