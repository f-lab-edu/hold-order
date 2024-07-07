package com.holdOrder.HoldOrder.application.application;

import com.holdOrder.HoldOrder.application.dto.goodsOption.*;
import com.holdOrder.HoldOrder.application.mapper.GoodsOptionDtoMapper;
import com.holdOrder.HoldOrder.core.dto.goodsOption.GoodsOptionDto;
import com.holdOrder.HoldOrder.core.mapper.GoodsOptionMapper;
import com.holdOrder.HoldOrder.core.service.GoodsOptionCommandService;
import com.holdOrder.HoldOrder.core.service.GoodsOptionFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GoodsOptionApplication {
    private final GoodsOptionCommandService goodsOptionCommandService;
    private final GoodsOptionFindService goodsOptionFindService;

    public GoodsOptionFindResponseDto find(Long goodsOptionId) {
        GoodsOptionDto goodsOptionDto = goodsOptionFindService.find(goodsOptionId);
        return GoodsOptionDtoMapper.INSTANCE.goodsOptionDtoToGoodsOptionFindResponseDto(goodsOptionDto);
    }

    public GoodsOptionSaveResponseDto saveWithSort(GoodsOptionSaveRequestDto goodsOptionSaveRequestDto) {
        GoodsOptionDto goodsOptionDto = goodsOptionCommandService.saveWithSort(GoodsOptionMapper.INSTANCE.goodsOptionToGoodsOptionDto(goodsOptionSaveRequestDto.getGoodsOption()), goodsOptionSaveRequestDto.getGoodsId());
        return GoodsOptionDtoMapper.INSTANCE.goodsOptionDtoToGoodsOptionSaveResponseDto(goodsOptionDto);
    }

    public GoodsOptionModifyResponseDto modify(GoodsOptionModifyRequestDto goodsOptionModifyRequestDto) {
        GoodsOptionDto modify = goodsOptionCommandService.modify(GoodsOptionDtoMapper.INSTANCE.goodsOptionModifyRequestDtoToGoodsOptionDto(goodsOptionModifyRequestDto));
        return GoodsOptionDtoMapper.INSTANCE.goodsOptionDtoToGoodsOptionModifyResponseDto(modify);
    }

    public void remove(Long id) {
        goodsOptionCommandService.remove(id);
    }
}
