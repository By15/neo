package com.neo.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class DemoTest {
    @RequestMapping("/World")
    public String helloWorld(String s){
        System.out.println("传入的值为："+s);
        return "传入的值为："+s;
    }

}
