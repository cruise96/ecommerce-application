package com.spendkey.ecommerce.Controller;
import com.spendkey.ecommerce.DTO.CartItemDTO;
import com.spendkey.ecommerce.ServiceLayer.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @GetMapping("")
    public ResponseEntity<List<CartItemDTO>> getCartItemsOfUser(@RequestParam(required=false) Integer userId) {
        try {
            List<CartItemDTO> cartItems = cartService.getCartItems(userId);
            return ResponseEntity.ok(cartItems);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addItemToCart(@RequestParam Integer productId) {
        try {
            return ResponseEntity.ok(cartService.addToCart(productId));
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateItemInCart(@RequestParam Integer productId, @RequestParam Integer quantity) {
        try {

            return ResponseEntity.ok(cartService.updateCartItem(quantity, 1, productId));
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
