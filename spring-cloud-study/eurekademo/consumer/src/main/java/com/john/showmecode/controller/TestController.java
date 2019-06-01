package com.john.showmecode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/info")
    public String info(){
        String info = restTemplate.getForEntity("http://TEST-SERVICE/info", String.class).getBody();
        String info2 = restTemplate.getForObject("http://TEST-SERVICE/info", String.class);
        return "info = " + info + " && info2 = " + info2;
    }
}
