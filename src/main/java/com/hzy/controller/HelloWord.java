package com.hzy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jim on 2018/10/26.
 */
@RestController
public class HelloWord {
    @GetMapping("hello")
    public String helloSpringBoot2() {
        return "helloSpringBoot2";
    }
}
