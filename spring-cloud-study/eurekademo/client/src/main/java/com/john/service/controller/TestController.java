package com.john.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/info")
    public String info(){
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        String info = "host: " + instance.getHost() + " && serviceId: " + instance.getServiceId();
        return info;
    }
}
