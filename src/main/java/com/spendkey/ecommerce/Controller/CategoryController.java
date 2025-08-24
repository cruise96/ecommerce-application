package com.spendkey.ecommerce.Controller;
import com.spendkey.ecommerce.Models.CategoryTree;
import com.spendkey.ecommerce.ServiceLayer.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryTree>> getCategories() {
        try {
            List<CategoryTree> categoryTree = categoryService.getCategoriesTree();
            return ResponseEntity.ok(categoryTree);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
