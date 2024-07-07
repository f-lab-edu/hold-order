package com.holdOrder.HoldOrder.core.dto.goodsOption;

import com.holdOrder.HoldOrder.core.domain.goods.Goods;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoodsOptionDto {
    private Long id;
    private Goods goods;
    private String name;
    private Integer optionPrice;
    private Integer sort;
}
