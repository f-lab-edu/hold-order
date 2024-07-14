package com.holdOrder.HoldOrder.core.dto.goods;

import com.holdOrder.HoldOrder.core.domain.goods.GoodsDeletedState;
import com.holdOrder.HoldOrder.core.domain.goods.GoodsUsedState;
import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.core.domain.seller.Seller;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
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
    private GoodsUsedState usedYn;
    private GoodsDeletedState deletedYn;
    private List<GoodsOption> goodsOptions;
    private String creator;
    private String modifier;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    // search
    private String nameLike;
    private String sellerNameLike;
    private Integer goodsPriceFrom;
    private Integer goodsPriceTo;
    private LocalDateTime createdAtFrom;
    private LocalDateTime createdAtTo;
    private Integer pageIndex;
    private Integer pageSize;

}
