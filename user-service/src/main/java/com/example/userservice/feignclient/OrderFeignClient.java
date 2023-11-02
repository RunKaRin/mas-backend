package com.example.userservice.feignclient;

import com.example.userservice.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ORDER-SERVICE", path = "order-service") // order-service 유레카에 등록된 서비스의
public interface OrderFeignClient {

    @GetMapping("/orders/{userId}/users") // 이 주소로 호출을 넣으면
    public List<Order> getOrderListByUserId(@PathVariable String userId); // 요청을 처리해 준다.
}
