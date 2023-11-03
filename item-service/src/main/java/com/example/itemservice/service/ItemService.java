package com.example.itemservice.service;

import com.example.itemservice.domain.Item;
import com.example.itemservice.domain.Order;
import com.example.itemservice.dto.RequestCreateItemDto;
import com.example.itemservice.dto.ResponseFindItemDto;
import com.example.itemservice.dto.ResponseOrderByItemDto;
import com.example.itemservice.exception.ItemNotFoundException;
import com.example.itemservice.feignclient.OrderFeignClient;
import com.example.itemservice.repository.ItemRepository;
import com.example.itemservice.util.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final OrderFeignClient orderFeignClient;
    private final Producer producer;

    // 상품등록
    public void createItem(RequestCreateItemDto requestCreateItemDto) {

        itemRepository.save(requestCreateItemDto.toEntity());
    }

//    // productId(uuid) 기반으로 상품 찾기
//    public ResponseFindItemDto findItemByProductId(String productId) {
//        Item item = itemRepository.findItemByProductId(productId);
//
//        if (item == null)
//            throw new ItemNotFoundException("해당 상품은 존재하지 않습니다.");
//
//        ResponseFindItemDto dto = new ResponseFindItemDto(item);
//        return dto;
//    }

    public ResponseOrderByItemDto findOrderByItem(String productId) {
        Item item = itemRepository.findItemByProductId(productId)
//                .orElseThrow( () -> new RuntimeException("해당 아이템은 존재하지 않습니다."));
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 아이템은 존재하지 않습니다."));

        ResponseOrderByItemDto itemDto = new ResponseOrderByItemDto(item);

        List<Order> orderList = orderFeignClient.getOrdersByItemId(productId);

        itemDto.setOrderList(orderList);

        return itemDto;
    }

    public void publishTestMessage(String message) {
        producer.sendTestMessage(message);
    }

}
