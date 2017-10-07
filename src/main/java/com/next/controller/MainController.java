package com.next.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/")
public class MainController {

    @RequestMapping
    public String welcome() {
        return "Welcome!";
    }

}
