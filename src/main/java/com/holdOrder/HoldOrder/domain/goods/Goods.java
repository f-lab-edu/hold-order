package com.holdOrder.HoldOrder.domain.goods;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Builder
public class Goods {

    private String goodsId;
    private String categoryId;
    private String sellerId;
    private int goodsPrice;
    private String intr;
    private String imgUrl;
    private Timestamp regiDt;
    private Timestamp updaDt;

}