package com.spendkey.ecommerce.ServiceLayer;
import com.spendkey.ecommerce.Models.Product;
import com.spendkey.ecommerce.RepositoryLayer.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    private final CategoryService categoryService;
    @Autowired
    private final ProductRepository productRepository;
    public ProductService(CategoryService categoryService, ProductRepository productRepository) {
        this.categoryService = categoryService;
        this.productRepository = productRepository;
    }
    public List<Integer> getSubCategories(Integer categoryId) {
        return categoryService.getSubCategories(categoryId);
    }
    public List<Product> getProductsUnderCategories(Integer categoryId) {
        List<Integer> subCategories = getSubCategories(categoryId);
        return categoryId == null ? productRepository.findAll() : productRepository.getProductsInCategory(subCategories);
    }
}
