package com.holdOrder.HoldOrder.application.dto.goods;

import com.holdOrder.HoldOrder.core.domain.seller.Seller;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GoodsSearchResponseDto {
    private List<GoodsInfoResponseDto> goodsFindResponseDtoList;
    private Integer totalCount;

}
