package com.spendkey.ecommerce.Controller;
import com.spendkey.ecommerce.Models.Product;
import com.spendkey.ecommerce.ServiceLayer.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(required=false) Integer categoryId) {
        try {
            List<Product> products = productService.getProductsUnderCategories(categoryId);
            return ResponseEntity.ok(products);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
