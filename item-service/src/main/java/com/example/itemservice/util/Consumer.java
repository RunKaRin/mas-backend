package com.example.itemservice.util;

import com.example.itemservice.dto.RequestCreateItemDto;
import com.example.itemservice.service.ItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {

    private final ObjectMapper objectMapper;
    private final ItemService itemService;

//    @RabbitListener(queues = "ITEM_CREATE_QUEUE")
//    public void getTestMessage(String message) throws InterruptedException {
//        System.out.println("큐에서 뽑아낸 메시지 : " + message);
//    }

    @RabbitListener(queues = "ITEM_CREATE_QUEUE")
    public void createItem(String message) throws JsonProcessingException {
        // objectMapper.readValue("String 형식의 JSON", 목적객체.class);
        RequestCreateItemDto dto = objectMapper.readValue(message, RequestCreateItemDto.class);

        // service에서 Dto를 입력받아 DB에서 INSERT해주는 로직
        itemService.createItem(dto);
    }
}
