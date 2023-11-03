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

}
