package com.holdOrder.HoldOrder.application.dto.goods;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GoodsSaveResponseDto {
    private Long id;
    private Long sellerId;
    private String name;
    private Integer goodsPrice;
    private String creator;
    private LocalDateTime createdAt;
}
