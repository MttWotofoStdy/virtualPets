package com.example.perestoronin.springbook.simple_spring_boot_mvc.controller.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "api/v1/PublicService",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces =MediaType.APPLICATION_JSON_VALUE )
public class PublicController {


}
