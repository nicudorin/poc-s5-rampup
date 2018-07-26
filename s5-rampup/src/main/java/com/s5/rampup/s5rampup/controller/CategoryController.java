package com.s5.rampup.s5rampup.controller;

import com.s5.rampup.s5rampup.domain.Category;
import com.s5.rampup.s5rampup.dto.CategoryDto;
import com.s5.rampup.s5rampup.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="/categories", method=RequestMethod.POST)
    public Category createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.createCategory(categoryDto.getName());
    }

    @RequestMapping(value="/categories/{id}", method = RequestMethod.PUT)
    public Category updateCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(categoryDto.getId(), categoryDto.getName());
    }

    @RequestMapping(value = "/categories/{id}")
    public Category getCategory(@PathVariable int id) {
        return categoryService.getCategory(id);
    }

    @RequestMapping(value = "/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }
}
