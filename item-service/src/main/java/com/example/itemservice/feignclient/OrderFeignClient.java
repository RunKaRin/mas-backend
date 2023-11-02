package com.example.itemservice.feignclient;

import com.example.itemservice.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ORDER-SERVICE", path = "order-service") // order service 쪽으로 요청할 예정
public interface OrderFeignClient {

    // productId 기준 orderList 조회
    @GetMapping("/orders/{productId}/products")
    public List<Order> getOrdersByItemId(@PathVariable String productId);
}
