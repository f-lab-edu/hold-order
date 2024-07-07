package com.holdOrder.HoldOrder.application.dto.goods;

import lombok.Data;

@Data
public class GoodsSaveRequestDto {
    private String sellerId;
    private String name;
    private String goodsImageUrl;
    private Integer goodsPrice;
}
