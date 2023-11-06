package com.example.itemservice.util;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

    // 멤버변수로 RabbitTemplate 생성
    private final RabbitTemplate rabbitTemplate;

    public void sendTestMessage(String message) {
        rabbitTemplate.convertAndSend("ITEM_CREATE_QUEUE", message);
    }

    // 어차피 java object를 String으로 바꿔야 하기 때문에 크게 달라질 것은 없음
    public void sendCreateMessage(String message) {
        rabbitTemplate.convertAndSend("ITEM_CREATE_QUEUE", message);
    }

}
