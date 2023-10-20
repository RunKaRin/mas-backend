package com.playdata.firstservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("first-service") // gateway서버의 predicates의 식별 주소를 추가 해야 한다.
@RequiredArgsConstructor
public class FirstServiceController {
    
    private final Environment env;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello, First-service!";
    }

    @GetMapping("header-check")
    public String headerCheck(@RequestHeader("first-service_req_h") String header) {
        return header;
    }
    
    @GetMapping("port-check")
    public String portCheck() {
        // 그냥 server.port로 기입하면 실제로 대입된 값인 0으로 출력됨
        return env.getProperty("local.server.port")
                + "/"
                + env.getProperty("test.value");
    }
}
