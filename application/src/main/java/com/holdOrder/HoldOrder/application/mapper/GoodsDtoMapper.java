package com.holdOrder.HoldOrder.application.mapper;

import com.holdOrder.HoldOrder.application.dto.goods.GoodsSaveRequestDto;
import com.holdOrder.HoldOrder.core.dto.goods.GoodsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GoodsDtoMapper {
    GoodsDtoMapper INSTANCE = Mappers.getMapper(GoodsDtoMapper.class);


    GoodsDto map(GoodsSaveRequestDto goodsSaveRequestDto);

}
