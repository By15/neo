package com.neo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/demo")
public class DemoConsumer {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String helloWorld(){
        System.out.println("传入的值为："+1);

        //第三种调用方式 需要restTemplate注入的方式
        String forObject = restTemplate.getForObject("http://by15-User/hello/World", String.class);
        return forObject;
    }

}
