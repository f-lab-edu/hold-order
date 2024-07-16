package com.holdOrder.HoldOrder.application.mapper;

import com.holdOrder.HoldOrder.application.dto.goodsOption.*;
import com.holdOrder.HoldOrder.core.dto.goodsOption.GoodsOptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GoodsOptionDtoMapper {
    GoodsOptionDtoMapper INSTANCE = Mappers.getMapper(GoodsOptionDtoMapper.class);

    GoodsOptionDto map(GoodsOptionModifyRequestDto goodsOptionModifyRequestDto);

}
