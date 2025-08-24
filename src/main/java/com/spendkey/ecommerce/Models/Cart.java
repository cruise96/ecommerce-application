package com.spendkey.ecommerce.Models;
import jakarta.persistence.*;
@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "user_id")
    Integer userId;

    Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Cart() {}
    public Cart(Integer productId, Integer quantity) {
        this.userId = 1;
        this.product = new Product();
        this.product.setId(productId);
        this.quantity = quantity;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
