package com.holdOrder.HoldOrder.core.mapper;

import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.core.dto.goodsOption.GoodsOptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GoodsOptionMapper {
    GoodsOptionMapper INSTANCE = Mappers.getMapper(GoodsOptionMapper.class);

    GoodsOptionDto goodsOptionToGoodsOptionDto(GoodsOption goodsOption);
    GoodsOption goodsOptionDtoToGoodsOption(GoodsOptionDto goodsOptionDto);


}
