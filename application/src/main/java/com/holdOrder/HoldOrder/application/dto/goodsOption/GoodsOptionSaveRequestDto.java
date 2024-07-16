package com.holdOrder.HoldOrder.application.dto.goodsOption;

import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOption;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class GoodsOptionSaveRequestDto {
    Long goodsId;
    GoodsOption goodsOption;

    private String creator;
    private LocalDateTime createdAt;
}
