package com.s5.rampup.s5rampup.service;

import com.s5.rampup.s5rampup.domain.Category;
import com.s5.rampup.s5rampup.persistence.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);

        categoryMapper.createCategory(category);

        return category;
    }

    public Category updateCategory(int id, String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);

        categoryMapper.updateCategory(category);

        return category;
    }

    public Category getCategory(int id) {
        return categoryMapper.getCategory(id);
    }

    public List<Category> getCategories() {
        return categoryMapper.getCategories();
    }

    public void deleteCategory(int id) {
        categoryMapper.deleteCategory(id);
    }
}
