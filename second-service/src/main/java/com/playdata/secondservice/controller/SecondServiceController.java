package com.playdata.secondservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("second-service")
public class SecondServiceController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello, Second-service!";
    }

    @GetMapping("header-check")
    public String headerCheck(@RequestHeader("second-service_req_h") String header) {
        return header;
    }
}
