package com.spendkey.ecommerce.ServiceLayer;
import com.spendkey.ecommerce.DTO.CartItemDTO;
import com.spendkey.ecommerce.Models.Cart;
import com.spendkey.ecommerce.RepositoryLayer.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService {
    @Autowired
    private final CartRepository cartRepository;
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    public List<CartItemDTO> getCartItems(Integer userId) {
        return cartRepository.findCartItemsByUserId(userId);
    }

    public String addToCart(Integer productId) {
        cartRepository.save(new Cart(productId, 1));
        return "Success";
    }
    public String updateCartItem(Integer quantity, Integer userId, Integer productId) {
        if(quantity==0)
            cartRepository.deleteByUserIdAndProduct_Id(userId, productId);
        else
            cartRepository.updateQuantityByUserIdAndProductId(quantity, userId, productId);

        return "Success";
    }
}
