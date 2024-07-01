package com.holdOrder.HoldOrder.dto.goods;

import com.holdOrder.HoldOrder.config.EntityDate;
import com.holdOrder.HoldOrder.domain.goods.Goods;
import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOption;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class GoodsInfoResponseDto extends EntityDate {
    private Long id;
    private String productName;
    private String sellerName;
    private String introduction;
    private Integer goodsPrice;
    private List<GoodsOption> goodsOptionList;

    public GoodsInfoResponseDto(Goods goods, List<GoodsOption> goodsOptionList) {
        this.id = goods.getId();
        this.productName = goods.getName();
        this.sellerName = goods.getSeller().getName();
        this.introduction = goods.getIntroduction();
        this.goodsPrice = goods.getGoodsPrice();
//        super.setCreatedAt(goods.getCreatedAt());
//        super.setModifiedAt(goods.getModifiedAt());
    }
}
