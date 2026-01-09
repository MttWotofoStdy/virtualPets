package com.example.perestoronin.springbook.simple_spring_boot_mvc.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

@GetMapping("/home")
    public String home() {
    return "Hello there, application works finally!";

}


}
