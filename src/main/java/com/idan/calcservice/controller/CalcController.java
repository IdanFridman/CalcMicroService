package com.idan.calcservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by idan on 11/20/14.
 */
@RestController
public class CalcController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!12333";
    }

}
