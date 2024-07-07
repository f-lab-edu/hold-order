package com.holdOrder.HoldOrder.application.dto.goods;

import lombok.Data;

@Data
public class GoodsSaveResponseDto {
    private String id;
    private String sellerId;
    private String name;
    private Integer goodsPrice;
}
