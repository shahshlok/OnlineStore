// src/main/java/com/store/model/OrderProduct.java
package com._4.OnlineStore.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orderproduct", schema = "dbo")
public class OrderProduct {

    @EmbeddedId
    private OrderProductPK id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "orderId")
    private OrderSummary orderSummary;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

    // Default Constructor
    public OrderProduct() {}

    // Constructor with parameters
    public OrderProduct(OrderSummary orderSummary, Product product, Integer quantity, BigDecimal price) {
        this.id = new OrderProductPK(orderSummary.getOrderId(), product.getProductId());
        this.orderSummary = orderSummary;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public OrderProductPK getId() {
        return id;
    }

    public void setId(OrderProductPK id) {
        this.id = id;
    }

    public OrderSummary getOrderSummary() {
        return orderSummary;
    }

    public void setOrderSummary(OrderSummary orderSummary) {
        this.orderSummary = orderSummary;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "orderId=" + (orderSummary != null ? orderSummary.getOrderId() : null) +
                ", productId=" + (product != null ? product.getProductId() : null) +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}