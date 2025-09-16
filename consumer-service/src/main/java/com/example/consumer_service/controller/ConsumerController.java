package com.example.consumer_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ConsumerController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/consume")
    public String consumeHello() {
        // Eureka will give Hello Backend URL
        String serviceUrl = discoveryClient
                .getInstances("hello-backend")
                .get(0)
                .getUri()
                .toString();

        // Call Hello Backend
        String response = restTemplate.getForObject(serviceUrl + "/api/name", String.class);

        return "Consumer got → " + response;
    }
}
