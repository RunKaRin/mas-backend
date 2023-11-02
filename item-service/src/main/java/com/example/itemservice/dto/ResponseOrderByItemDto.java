package com.example.itemservice.dto;

import com.example.itemservice.domain.Item;
import com.example.itemservice.domain.Order;
import lombok.*;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class ResponseOrderByItemDto {

    private Long id;
    private String productId;
    private String productName;
    private Long stock;
    private Long pricePerItem;
    private List<Order> orderList;

    // 생성자의 파라미터로 item을 넘기면 알아서 dto로 변환해줌

    public ResponseOrderByItemDto(Item item) {
        this.id = item.getId();
        this.productId = item.getProductId();
        this.productName = item.getProductName();
        this.stock = item.getStock();
        this.pricePerItem = item.getPricePerItem();
    }
}
