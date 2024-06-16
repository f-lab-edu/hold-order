package com.holdOrder.HoldOrder.dto.goodsOption;

import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOption;

public class GoodsOptionModifyResponseDto {
    private Long id;
    private String name;
    private Integer optionPrice;
    private Integer sort;

    public GoodsOptionModifyResponseDto(GoodsOption goodsOption) {
        this.id = goodsOption.getId();
        this.name = goodsOption.getName();
        this.optionPrice = goodsOption.getOptionPrice();
        this.sort = goodsOption.getSort();
    }
}
