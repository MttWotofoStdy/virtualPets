package com.example.perestoronin.springbook.simple_spring_boot_mvc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableConfigServer
public class VirtualpetsConfigApplication {
public static void main(String[] args) {
    SpringApplication.run (VirtualpetsConfigApplication.class, args);
}
}
