package com.example.itemservice.controller;

import com.example.itemservice.dto.RequestCreateItemDto;
import com.example.itemservice.dto.ResponseFindItemDto;
import com.example.itemservice.dto.ResponseOrderByItemDto;
import com.example.itemservice.service.ItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("item-service")
public class ItemController {

    private final ItemService itemService;
    private final Environment env;

    // 직렬화, 역직렬화 담당 라이브러리.
    private final ObjectMapper objectMapper;

    @RequestMapping("health-check")
    public String healthCheck() {
        return "item-service server is available!";
    }

    // 상품등록
    @PostMapping("items")
    public ResponseEntity<?> createItem(@Valid @RequestBody RequestCreateItemDto requestCreateItemDto)
            throws JsonProcessingException {
//        itemService.createItem(requestCreateItemDto);
//        return new ResponseEntity(HttpStatus.CREATED);

        // 메시지 큐로 전달만 하면 됨.
        itemService.publishCreateMessage(requestCreateItemDto);
        return ResponseEntity.ok("메시지큐에 생성 요청 적재 완료.");
    }

//    // productId(uuid) 기반으로 상품 찾기
//    @GetMapping("items/{productId}")
//    public ResponseEntity<?> findItemByProductId(@PathVariable String productId) {
//        ResponseFindItemDto item = itemService.findItemByProductId(productId);
//        return ResponseEntity.ok(item);
//    }

    @GetMapping("port-check")
    public String portCheck() {
        // 그냥 server.port로 기입하면 실제로 대입된 값인 0으로 출력됨
        return env.getProperty("local.server.port")
                + "/"
                + env.getProperty("test.value");
    }

    @GetMapping("profile-check")
    public String profileCheck() {
        return env.getProperty("pro.file");
    }

    // productId 기준 orderList 조회
    @GetMapping("items/{productId}/orders")
    public ResponseEntity<?> getOrderByProductId(@PathVariable String productId) {
        ResponseOrderByItemDto itemDto = itemService.findOrderByItem(productId);
        return ResponseEntity.ok(itemDto);
    }

    // RabbitMQ 메세지
    @GetMapping("items/{message}/message")
    public ResponseEntity<?> publishTestMessage(@PathVariable String message) {
        itemService.publishTestMessage(message);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
