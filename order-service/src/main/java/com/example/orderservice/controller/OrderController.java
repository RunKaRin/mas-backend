package com.example.orderservice.controller;
import com.example.orderservice.domain.Order;
import com.example.orderservice.dto.RequestCreateOrderDto;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // userId 기준 orderList 조회
    @GetMapping("orders/{userId}/users")
    public ResponseEntity<?> getOrderListByUserId(@PathVariable String userId) {
        List<Order> orderList = orderService.getOrderListByUserId(userId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 유저 아이디 입니다."))
                .stream().toList();
        return ResponseEntity.ok(orderList);
    }

    // productId 기준 orderList 조회
    @GetMapping("orders/{productId}/products")
    public ResponseEntity<?> getOrderListByProductId(@PathVariable String productId) {
        List<Order> orderList = orderService.getOrderListByProductId(productId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 상품 아이디 입니다."))
                .stream().toList();
        return ResponseEntity.ok(orderList);
    }
}
