package com._4.OnlineStore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

    @GetMapping({"/", "/shop"})
    public String showShopPage() {
        return "shop";
    }
}