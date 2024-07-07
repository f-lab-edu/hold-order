package com.holdOrder.HoldOrder.application.dto.goods;

import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOption;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class GoodsInfoResponseDto {
    private Long id;
    private String name;
    private String sellerId;
    private String intr;
    private Integer goodsPrice;
    private List<GoodsOption> goodsOptionList;

}
