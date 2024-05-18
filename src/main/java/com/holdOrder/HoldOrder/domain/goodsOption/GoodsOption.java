package com.holdOrder.HoldOrder.domain.goodsOption;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Builder
public class GoodsOption {

    private String optionId;
    private String goodsId;
    private String optionNm;
    private int optionPrice;
    private int sort;
    private Timestamp regiDt;
    private Timestamp updaDt;

}
