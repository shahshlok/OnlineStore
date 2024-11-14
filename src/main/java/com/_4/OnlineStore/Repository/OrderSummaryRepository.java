package com._4.OnlineStore.Repository;

import com._4.OnlineStore.Model.OrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderSummaryRepository extends JpaRepository<OrderSummary, Integer> {
    @Query("SELECT DISTINCT o FROM OrderSummary o " +
            "LEFT JOIN FETCH o.customer " +
            "LEFT JOIN FETCH o.orderProducts op " +
            "LEFT JOIN FETCH op.product")
    List<OrderSummary> findAllWithCustomerAndProducts();
}