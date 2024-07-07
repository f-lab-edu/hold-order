package com.holdOrder.HoldOrder.core.mapper;

import com.holdOrder.HoldOrder.core.domain.goods.Goods;
import com.holdOrder.HoldOrder.core.dto.goods.GoodsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GoodsMapper {
    GoodsMapper INSTANCE = Mappers.getMapper(GoodsMapper.class);

    GoodsDto map(Goods goods);

    Goods map(GoodsDto goodsDto);
}
