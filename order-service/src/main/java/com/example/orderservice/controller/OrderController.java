package com.example.orderservice.controller;
import com.example.orderservice.dto.RequestCreateOrderDto;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("order-service")
public class OrderController {

    private final OrderService orderService;

    @RequestMapping("health-check")
    public String healthCheck() {
        return "order-service server is available!";
    }

    // 주문
    @PostMapping("orders")
    public ResponseEntity<?> createOrder(@RequestBody RequestCreateOrderDto requestCreateOrderDto) {
        orderService.createOrder(requestCreateOrderDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
