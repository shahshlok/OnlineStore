package com._4.OnlineStore.Controller;

import com._4.OnlineStore.Repository.OrderSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    private final OrderSummaryRepository orderSummaryRepository;

    @Autowired
    public OrderController(OrderSummaryRepository orderSummaryRepository) {
        this.orderSummaryRepository = orderSummaryRepository;
    }

    @GetMapping("/orders")
    public String listOrders(Model model) {
        try {
            model.addAttribute("orders", orderSummaryRepository.findAllWithCustomerAndProducts());
            return "listOrders";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}