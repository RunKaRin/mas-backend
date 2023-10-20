package com.example.itemservice.dto;

import com.example.itemservice.domain.Item;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResponseFindItemDto {

    private String productId;
    private String productName;
    private Long stock;
    private Long pricePerItem;

    public ResponseFindItemDto(Item item) {
        this.productId = item.getProductId();
        this.productName = item.getProductName();
        this.stock = item.getStock();
        this.pricePerItem = item.getPricePerItem();
    }
}
