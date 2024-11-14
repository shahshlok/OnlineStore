// src/main/java/com/store/model/Customer.java
package com._4.OnlineStore.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer", schema = "dbo")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Integer customerId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @OneToMany(mappedBy = "customer")
    private List<OrderSummary> orders;

    // Constructors
    public Customer() {}

    // Getters and Setters
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<OrderSummary> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderSummary> orders) {
        this.orders = orders;
    }
}