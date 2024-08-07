package com.holdOrder.HoldOrder.core.dto.seller;

import com.holdOrder.HoldOrder.core.domain.goods.Goods;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SellerDto {
    private Long id;
    private String name;
    private List<Goods> goodsList;
}
