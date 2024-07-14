package com.holdOrder.HoldOrder.core.mapper;

import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.core.dto.goodsOption.GoodsOptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GoodsOptionMapper {
    GoodsOptionMapper INSTANCE = Mappers.getMapper(GoodsOptionMapper.class);

    GoodsOptionDto map(GoodsOption goodsOption);
    GoodsOption map(GoodsOptionDto goodsOptionDto);
    List<GoodsOptionDto> map(List<GoodsOption> goodsOptionList);

}
