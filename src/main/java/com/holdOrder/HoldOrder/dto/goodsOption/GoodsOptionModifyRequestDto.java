package com.holdOrder.HoldOrder.dto.goodsOption;

import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOption;

public class GoodsOptionModifyRequestDto {


    public GoodsOption toEntity() {
        return GoodsOption.builder().build();
    }
}
