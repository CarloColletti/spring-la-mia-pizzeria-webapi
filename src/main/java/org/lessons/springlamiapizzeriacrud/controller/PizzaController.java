package org.lessons.springlamiapizzeriacrud.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/")
public class PizzaController {
    @GetMapping
    public String index() {
        return "index";
    }
}
