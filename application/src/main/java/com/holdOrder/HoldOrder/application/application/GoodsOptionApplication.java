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
        return GoodsOptionFindResponseDto.builder()
                .id(String.valueOf(goodsOptionDto.getId()))
                .name(goodsOptionDto.getName())
                .optionPrice(goodsOptionDto.getOptionPrice())
                .creator(goodsOptionDto.getCreator())
                .modifier(goodsOptionDto.getModifier())
                .createdAt(goodsOptionDto.getCreatedAt())
                .modifiedAt(goodsOptionDto.getModifiedAt())
                .build();
    }

    public GoodsOptionSaveResponseDto saveWithSort(GoodsOptionSaveRequestDto goodsOptionSaveRequestDto) {
        GoodsOptionDto goodsOptionDto = goodsOptionCommandService.saveWithSort(GoodsOptionMapper.INSTANCE.map(goodsOptionSaveRequestDto.getGoodsOption()), goodsOptionSaveRequestDto.getGoodsId());
        return GoodsOptionSaveResponseDto.builder()
                .name(goodsOptionDto.getName())
                .optionPrice(goodsOptionDto.getOptionPrice())
                .sort(goodsOptionDto.getSort())
                .creator(goodsOptionDto.getCreator())
                .createdAt(goodsOptionDto.getCreatedAt())
                .build();
    }

    public GoodsOptionModifyResponseDto modify(GoodsOptionModifyRequestDto goodsOptionModifyRequestDto) {
        GoodsOptionDto modify = goodsOptionCommandService.modify(GoodsOptionDtoMapper.INSTANCE.map(goodsOptionModifyRequestDto));
        return GoodsOptionModifyResponseDto.builder()
                .id(modify.getId())
                .name(modify.getName())
                .optionPrice(modify.getOptionPrice())
                .sort(modify.getSort())
                .modifier(modify.getModifier())
                .modifiedAt(modify.getModifiedAt())
                .build();
    }

    public void remove(Long id) {
        goodsOptionCommandService.remove(id);
    }
}
