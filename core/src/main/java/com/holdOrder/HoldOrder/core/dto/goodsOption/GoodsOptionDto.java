package com.holdOrder.HoldOrder.core.dto.goodsOption;

import com.holdOrder.HoldOrder.core.domain.goods.Goods;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GoodsOptionDto {
    private Long id;
    private Goods goods;
    private String name;
    private Integer optionPrice;
    private Integer sort;
    private String creator;
    private String modifier;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
