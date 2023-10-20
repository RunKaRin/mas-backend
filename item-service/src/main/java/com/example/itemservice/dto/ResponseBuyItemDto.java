package com.example.itemservice.dto;

import lombok.*;

@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class ResponseBuyItemDto {

    private String productId;
    private String productName;
    Long stock;
    Long pricePerItem;
    String userId;
    String orderId;
}
