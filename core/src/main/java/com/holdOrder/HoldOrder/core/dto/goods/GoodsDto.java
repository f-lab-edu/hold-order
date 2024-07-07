package com.holdOrder.HoldOrder.core.dto.goods;

import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.core.domain.seller.Seller;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GoodsDto {
    private Long id;
    private Seller seller;
    private String name;
    private String introduction;
    private String goodsImageUrl;
    private Integer goodsPrice;
    private Boolean usedYn;
    private Boolean deletedYn;
    private List<GoodsOption> goodsOptions;
}
