package com.holdOrder.HoldOrder.application.dto.goodsOption;

import lombok.Data;

@Data
public class GoodsOptionSaveResponseDto {
    private String name;
    private String optionPrice;
    private Integer sort;
}
