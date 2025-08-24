package com.spendkey.ecommerce.ServiceLayer;
import com.spendkey.ecommerce.Models.Category;
import com.spendkey.ecommerce.Models.CategoryTree;
import com.spendkey.ecommerce.RepositoryLayer.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<CategoryTree> getCategoriesTree() {
        List<Category> categories = categoryRepository.findAll();

        Map<Integer, CategoryTree> map = new HashMap<>();
        for(Category c:categories) {
            map.put(c.getId(),new CategoryTree(c));
        }

        List<CategoryTree> roots = new ArrayList<>();

        for (Category c : categories) {
            CategoryTree node = map.get(c.getId());
            if (c.getParentId() == null) {
                roots.add(node);
            } else {
                CategoryTree parentNode = map.get(c.getParentId());
                if (parentNode != null) {
                    parentNode.getChildCategories().add(node);
                }
            }
        }
        return roots;
    }
    @Transactional(readOnly = true)
    public List<Integer> getSubCategories(Integer categoryId) {
        return categoryRepository.getSubCategories(categoryId);
    }

}
