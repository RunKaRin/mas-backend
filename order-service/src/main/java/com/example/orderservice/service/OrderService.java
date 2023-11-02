package com.example.orderservice.service;

import com.example.orderservice.domain.Order;
import com.example.orderservice.dto.RequestCreateOrderDto;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    // 주문
    public void createOrder(RequestCreateOrderDto requestCreateOrderDto) {

        orderRepository.save(requestCreateOrderDto.toEntity());
    }

    // userId를 입력하면 Order 리스트를 넘겨주는 메서드 호출을 통해 리턴
    public Optional<List<Order>> getOrderListByUserId(String userId) {
        return orderRepository.findOrderByUserId(userId);
    }

    //
    public Optional<List<Order>> getOrderListByProductId(String productId) {
        return orderRepository.findOrderByProductId(productId);
    }
}
