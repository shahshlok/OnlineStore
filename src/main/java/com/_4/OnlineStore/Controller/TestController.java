package com._4.OnlineStore.Controller;

import com._4.OnlineStore.Model.Product;
import com._4.OnlineStore.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/test")
    public String testConnection(Model model) {
        try {
            Iterable<Product> products = productRepository.findAll();
            StringBuilder message = new StringBuilder("Successfully connected! Products found:\n");

            for (Product product : products) {
                message.append("\nProduct ID: ")
                        .append(product.getProductId())
                        .append(", Name: ")
                        .append(product.getProductName())
                        .append(", Price: ")
                        .append(product.getProductPrice());
            }

            model.addAttribute("message", message.toString());
        } catch (Exception e) {
            model.addAttribute("message", "Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        return "test";
    }
}