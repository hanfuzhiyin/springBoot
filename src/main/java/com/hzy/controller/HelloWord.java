package com.hzy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWord {
    @GetMapping("hello")
    public String helloSpringBoot2() {
        return "hello SpringBoot2";
    }
}
