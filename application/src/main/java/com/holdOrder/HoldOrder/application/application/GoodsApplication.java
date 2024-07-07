package com.holdOrder.HoldOrder.application.application;

import com.holdOrder.HoldOrder.application.dto.goods.*;
import com.holdOrder.HoldOrder.application.mapper.GoodsDtoMapper;
import com.holdOrder.HoldOrder.core.domain.seller.Seller;
import com.holdOrder.HoldOrder.core.dto.goods.GoodsDto;
import com.holdOrder.HoldOrder.core.service.GoodsCommandService;
import com.holdOrder.HoldOrder.core.service.GoodsFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GoodsApplication {
    private final GoodsFindService goodsFindService;
    private final GoodsCommandService goodsCommandService;

    public GoodsSaveResponseDto save(GoodsSaveRequestDto goodsSaveRequestDto) {
        GoodsDto goodsDto = GoodsDtoMapper.INSTANCE.goodsSaveRequestDtoToGoodsDto(goodsSaveRequestDto);
        goodsDto.setSeller(Seller.builder().id(Long.valueOf(goodsSaveRequestDto.getSellerId())).build());

        GoodsDto savedGoods = goodsCommandService.save(goodsDto);
        GoodsSaveResponseDto goodsSaveResponseDto = GoodsDtoMapper.INSTANCE.goodsDtoToGoodsSaveResponseDto(savedGoods);
        goodsSaveResponseDto.setSellerId(String.valueOf(savedGoods.getSeller().getId()));
        return goodsSaveResponseDto;
    }

    public GoodsInfoResponseDto find(Long id) {
        GoodsDto findGoodsDto = goodsFindService.find(id);
        return GoodsDtoMapper.INSTANCE.goodsDtoToGoodsInfoResponseDto(findGoodsDto);
    }

    public List<GoodsInfoResponseDto> findList(Long sellerId) {
        List<GoodsDto> list = goodsFindService.findList(sellerId);
        return list.stream().map(GoodsDtoMapper.INSTANCE::goodsDtoToGoodsInfoResponseDto).collect(Collectors.toList());

    }
}
