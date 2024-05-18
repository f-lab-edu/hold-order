package com.holdOrder.HoldOrder.domain.goodsOption;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
public class GoodsOption {

    private String optionId;
    private String goodsId;
    private String optionNm;
    private int optionPrice;
    private int sort;
    private Timestamp regiDt;
    private Timestamp updaDt;

    @Builder
    public GoodsOption(String optionId, String goodsId, String optionNm, int optionPrice, int sort, Timestamp regiDt, Timestamp updaDt) {
        this.optionId = optionId;
        this.goodsId = goodsId;
        this.optionNm = optionNm;
        this.optionPrice = optionPrice;
        this.sort = sort;
        this.regiDt = regiDt;
        this.updaDt = updaDt;
    }
}
