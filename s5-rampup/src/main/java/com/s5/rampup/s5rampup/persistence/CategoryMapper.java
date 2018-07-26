package com.s5.rampup.s5rampup.persistence;

import com.s5.rampup.s5rampup.domain.Category;

import java.util.List;

public interface CategoryMapper {
    void createCategory(Category category);
    void updateCategory(Category category);
    Category getCategory(int id);
    List<Category> getCategories();
    void deleteCategory(int id);

}
