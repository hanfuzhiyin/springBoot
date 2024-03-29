package com.hxyc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.hxyc.mapper")
@SpringBootApplication
@EnableScheduling
public class Springboot2Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2Application.class, args);
    }

//继承SpringBootServletInitializer重写configure方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Springboot2Application.class);
    }

}
