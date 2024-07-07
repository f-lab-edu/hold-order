package com.holdOrder.HoldOrder.application.dto.goodsOption;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GoodsOptionFindResponseDto {
    private String id;
    private String name;
    private Integer optionPrice;
    private String creator;
    private String modifier;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
