package com._4.OnlineStore.Controller;

import com._4.OnlineStore.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class TestController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/test")
    public String testConnection(Model model){
        try{
            long count= productRepository.count();
            model.addAttribute("message", "Successfully connected. Found "+ count+ " Products");
        }catch (Exception e){
            model.addAttribute("message", "Connection Failed \n"+ e.getMessage());

        }
        return "test";
    }
}
