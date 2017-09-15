package com.techprimers.security.jwtsecurity.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/hello")
public class HelloController {

    @GetMapping
    public String hello(@RequestParam(value = "ancuk") String ancuk) {
        return "Hello World";
    }

}
