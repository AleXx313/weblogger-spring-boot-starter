package ru.mironov.weblogger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("hello")
@RequiredArgsConstructor
public class HelloController {

    private final RestTemplate restTemplate;
    private final RestClient restClient;

    @GetMapping
    public String sayHello(){
        return "Hello!";
    }
    @GetMapping("v1")
    public String sayHello1(){
        return restTemplate.getForObject("http://localhost:8080/hello", String.class);
    }
    @GetMapping("v2")
    public String sayHello2(){
        return restClient.get().uri("http://localhost:8080/hello").retrieve().body(String.class);
    }
}
