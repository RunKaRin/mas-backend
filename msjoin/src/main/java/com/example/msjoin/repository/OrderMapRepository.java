package com.example.msjoin.repository;

import com.example.msjoin.entity.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepository implements OrderRepository {

    private Map<Integer, Order> orderList;

    // 더미데이터를 맵 형태로 넣는다.
    public OrderMapRepository() {

        this.orderList = new HashMap<Integer, Order>();
        Order order1 = new Order(1, "감자", 3);
        Order order2 = new Order(1, "고구마", 2);
        Order order3 = new Order(2, "호박", 4);
        Order order4 = new Order(2, "가지", 1);
        orderList.put(1, order1);
        orderList.put(2, order2);
        orderList.put(3, order3);
        orderList.put(4, order4);
    }

    @Override
    public List<Order> getOrderByUserId(int userId) {
        List<Order> userOrderList = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            if (orderList.get(i).getUserId() == userId) {
                userOrderList.add(orderList.get(i));
            }
        }

        return userOrderList;
    }
}
