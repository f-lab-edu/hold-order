package com.holdOrder.HoldOrder.application.dto.goodsOption;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class GoodsOptionModifyResponseDto {
    private Long id;
    private String name;
    private Integer optionPrice;
    private Integer sort;
    private String modifier;
    private LocalDateTime modifiedAt;
}
