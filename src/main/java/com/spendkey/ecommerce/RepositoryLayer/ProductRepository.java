package com.spendkey.ecommerce.RepositoryLayer;
import com.spendkey.ecommerce.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("Select p from Product p where p.categoryId in :allCategories order by p.categoryId")
    List<Product> getProductsInCategory(@Param("allCategories") List<Integer> categories);

    List<Product> findAll();
}
