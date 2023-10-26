package com.demo.hellospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        StringBuilder message = new StringBuilder("*^*^*^*Welcome to My Hospital Management System!*^*^*^*");
        message.append(" ");
        message.append(" -----We are here to provide exceptional healthcare services.-----");
        message.append(" Feel free to explore our system and services.");
        message.append("1.Login     2.Doctors     3.patients   ");
        return message.toString();
    }
}
