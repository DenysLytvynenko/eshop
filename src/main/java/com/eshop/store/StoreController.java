package com.eshop.store;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {
    @RequestMapping("/")
    public String index(){
        return "Welcome to eShop";
    }
}
