package com.practice.ecommorce.Service;

import com.practice.ecommorce.Model.Category;
import com.practice.ecommorce.Repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CategoryServiceImpTest {

    @InjectMocks
    CategoryServiceImp categoryServiceImp;

    @Mock
    CategoryRepository categoryRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(categoryServiceImp, "categoryRepository", categoryRepository);

//        categoryServiceImp.categoryRepository = categoryRepository;
    }

    @Test
    void createCategoryTest() {
        Category category = new Category();
        category.setName("sbbb");
        when(categoryRepository.save(any())).thenReturn(category);
        Category books = categoryServiceImp.createCategory("books");

        assertNotNull(books);
        assertEquals("sbbb", books.getName());
    }

    @Test
    void findByNameTest() {
        Category category = new Category();
        category.setName("sbbb");
        when(categoryRepository.findByName(any())).thenReturn(category);
        Category books = categoryServiceImp.findByName("books");
        assertNotNull(books);
    }
}