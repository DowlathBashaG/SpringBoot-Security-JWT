package io.dowlath.springbootjwtsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Dowlath
 * @create 7/9/2020 3:18 PM
 */
@RestController
@RequestMapping("/rest/hello")
public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello world...";
    }
}
