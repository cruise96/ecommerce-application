package com.spendkey.ecommerce.RepositoryLayer;
import com.spendkey.ecommerce.DTO.CartItemDTO;
import com.spendkey.ecommerce.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    @Query("SELECT new com.spendkey.ecommerce.DTO.CartItemDTO(p.id, p.name, p.price, c.quantity) " +
            "FROM Cart c JOIN c.product p WHERE c.userId = :userId")
    List<CartItemDTO> findCartItemsByUserId(@Param("userId") Integer userId);

    @Modifying
    @Transactional
    @Query("UPDATE Cart c SET c.quantity = :quantity WHERE c.userId = :userId AND c.product.id = :productId")
    int updateQuantityByUserIdAndProductId(@Param("quantity") Integer quantity,
                                           @Param("userId") Integer userId,
                                           @Param("productId") Integer productId);

    @Modifying
    @Transactional
    void deleteByUserIdAndProduct_Id(Integer userId, Integer productId);
}
