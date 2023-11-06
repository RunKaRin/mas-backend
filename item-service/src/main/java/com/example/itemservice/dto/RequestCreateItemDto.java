package com.example.itemservice.dto;

import com.example.itemservice.domain.Item;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateItemDto {

    @Pattern(regexp = "^[a-zA-Z가-힣0-9]+", message = "영문, 한글, 숫자만 입력해 주세요") // 영문자, 숫자, 한글 1글자 이상 들어오면 허용, 아닌경우는 검증 실패
    @NotBlank(message = "상품명은 반드시 입력되어야 합니다.")
    private String productName;
    @Min(value = 0, message = "재고는 음수로 들어올 수 없습니다.")
    @Max(value = 9999, message = "재고는 9999개 이상 설정할 수 없습니다.")
    @NotNull(message = "재고는 반드시 입력되어야 합니다.")
    private Long stock;
    @Min(value = 0, message = "가격은 음수로 들어올 수 없습니다.")
    @NotNull(message = "가격은 반드시 입력되어야 합니다.")
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
