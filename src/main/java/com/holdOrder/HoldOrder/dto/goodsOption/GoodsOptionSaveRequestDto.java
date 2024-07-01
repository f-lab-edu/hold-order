package com.holdOrder.HoldOrder.dto.goodsOption;

import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class GoodsOptionSaveRequestDto {
    Long goodsId;
    GoodsOption goodsOption;

}
