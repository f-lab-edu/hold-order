package com.holdOrder.HoldOrder.application.mapper;

import com.holdOrder.HoldOrder.application.dto.goodsOption.*;
import com.holdOrder.HoldOrder.core.dto.goodsOption.GoodsOptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GoodsOptionDtoMapper {
    GoodsOptionDtoMapper INSTANCE = Mappers.getMapper(GoodsOptionDtoMapper.class);

    GoodsOptionDto goodsOptionSaveRequestDtoToGoodsOptionDto(GoodsOptionSaveRequestDto goodsOptionSaveRequestDto);
    GoodsOptionSaveResponseDto goodsOptionDtoToGoodsOptionSaveResponseDto(GoodsOptionDto goodsOptionDto);

    GoodsOptionDto goodsOptionModifyRequestDtoToGoodsOptionDto(GoodsOptionModifyRequestDto goodsOptionModifyRequestDto);

    GoodsOptionModifyResponseDto goodsOptionDtoToGoodsOptionModifyResponseDto(GoodsOptionDto goodsOptionDto);

    GoodsOptionFindResponseDto goodsOptionDtoToGoodsOptionFindResponseDto(GoodsOptionDto goodsOptionDto);

}
