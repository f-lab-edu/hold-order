package com.holdOrder.HoldOrder.application.dto.goodsOption;

import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOption;
import lombok.*;

@Data
public class GoodsOptionSaveRequestDto {
    Long goodsId;
    GoodsOption goodsOption;

}
