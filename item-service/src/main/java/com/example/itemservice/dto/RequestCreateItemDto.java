package com.example.itemservice.dto;

import com.example.itemservice.domain.Item;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateItemDto {

    private String productName;
    private Long stock;
    private Long pricePerItem;

    public Item toEntity() {

        return Item.builder()
                .productId(UUID.randomUUID().toString())
                .productName(this.productName)
                .stock(this.stock)
                .pricePerItem(this.pricePerItem)
                .build();
    }
}
