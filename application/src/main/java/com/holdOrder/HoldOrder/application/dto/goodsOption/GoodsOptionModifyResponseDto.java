package com.holdOrder.HoldOrder.application.dto.goodsOption;

import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GoodsOptionModifyResponseDto {
    private Long id;
    private String name;
    private Integer optionPrice;
    private Integer sort;
}
