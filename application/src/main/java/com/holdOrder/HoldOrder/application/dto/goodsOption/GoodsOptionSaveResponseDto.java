package com.holdOrder.HoldOrder.application.dto.goodsOption;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GoodsOptionSaveResponseDto {
    private String name;
    private Integer optionPrice;
    private Integer sort;
    private String creator;
    private LocalDateTime createdAt;
}