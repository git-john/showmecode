package com.myspring.startspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class StartSpringBootApplication {

    @RequestMapping("/")
    String index(){
        return "start spring boot~";
    }

    public static void main(String[] args) {
        SpringApplication.run(StartSpringBootApplication.class, args);
    }

}
