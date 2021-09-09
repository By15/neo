package com.neo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/demo")
public class DemoConsumer {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String helloWorld(@RequestParam(value = "s") String s){
        System.out.println("传入的值为："+s);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<String> exchange = restTemplate.exchange("http://by15-User:8701/hello/World?s=" + s, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        return exchange.getBody();
    }

}
