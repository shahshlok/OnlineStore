package com._4.OnlineStore.Repository;

import com._4.OnlineStore.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // JpaRepository<EntityClass, ID Type>
    // Product is our entity, Integer is the type of our primary key (productId)
}