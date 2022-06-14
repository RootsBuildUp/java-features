package com.example.JavaFeatures.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Test2Controller {
    @GetMapping("/test2")
    public void test2(){
        log.error("test2");
    }
}
