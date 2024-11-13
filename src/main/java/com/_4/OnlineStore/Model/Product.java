package com._4.OnlineStore.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product", schema = "dbo")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Integer productId;

    @Column(name= "productName")
    private String productName;

    @Column(name = "productPrice")
    private BigDecimal productPrice;

    // Getters and setters
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }
}
