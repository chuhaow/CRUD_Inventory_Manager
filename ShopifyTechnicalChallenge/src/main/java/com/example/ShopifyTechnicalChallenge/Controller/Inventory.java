package com.example.ShopifyTechnicalChallenge.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Inventory {
    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }
}
