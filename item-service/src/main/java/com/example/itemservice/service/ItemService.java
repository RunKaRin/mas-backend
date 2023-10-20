package com.example.itemservice.service;

import com.example.itemservice.domain.Item;
import com.example.itemservice.dto.RequestCreateItemDto;
import com.example.itemservice.dto.ResponseFindItemDto;
import com.example.itemservice.exception.ItemNotFoundException;
import com.example.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    // 상품등록
    public void createItem(RequestCreateItemDto requestCreateItemDto) {

        itemRepository.save(requestCreateItemDto.toEntity());
    }

    // productId(uuid) 기반으로 상품 찾기
    public ResponseFindItemDto findItemByProductId(String productId) {
        Item item = itemRepository.findItemByProductId(productId);

        if (item == null)
            throw new ItemNotFoundException("해당 상품은 존재하지 않습니다.");

        ResponseFindItemDto dto = new ResponseFindItemDto(item);
        return dto;
    }
}
