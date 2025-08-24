package com.spendkey.ecommerce.RepositoryLayer;
import com.spendkey.ecommerce.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Procedure(name = "GetSubCategories")
    List<Integer> getSubCategories(@Param("CategoryId") Integer category);
}
