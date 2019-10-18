package com.eshop.store.controller.testgui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/application/**")
    public String forward() {
        return "forward:/";
    }

}