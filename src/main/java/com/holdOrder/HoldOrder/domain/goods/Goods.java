package com.holdOrder.HoldOrder.domain.goods;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Entity
public class Goods {

    @Id
    private String goodsId;
    private String categoryId;
    private String sellerId;
    private int goodsPrice;
    private String intr;
    private String imgUrl;
    private Timestamp regiDt;
    private Timestamp updaDt;

    @Builder
    public Goods(String goodsId, String categoryId, String sellerId, int goodsPrice, String intr, String imgUrl, Timestamp regiDt, Timestamp updaDt) {
        this.goodsId = goodsId;
        this.categoryId = categoryId;
        this.sellerId = sellerId;
        this.goodsPrice = goodsPrice;
        this.intr = intr;
        this.imgUrl = imgUrl;
        this.regiDt = regiDt;
        this.updaDt = updaDt;
    }
}