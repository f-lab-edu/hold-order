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
        GoodsDto goodsDto = GoodsDtoMapper.INSTANCE.map(goodsSaveRequestDto);
        goodsDto.setSeller(Seller.builder().id(Long.valueOf(goodsSaveRequestDto.getSellerId())).build());

        GoodsDto savedGoods = goodsCommandService.save(goodsDto);

        GoodsSaveResponseDto goodsSaveResponseDto = GoodsSaveResponseDto.builder()
                .id(savedGoods.getId())
                .name(savedGoods.getName())
                .goodsPrice(savedGoods.getGoodsPrice())
                .creator(savedGoods.getCreator())
                .createdAt(savedGoods.getCreatedAt())
                .build();
        goodsSaveResponseDto.setSellerId(savedGoods.getSeller().getId());
        return goodsSaveResponseDto;
    }

    public GoodsInfoResponseDto find(Long id) {
        GoodsDto findGoodsDto = goodsFindService.find(id);

        return GoodsInfoResponseDto.builder()
                .id(findGoodsDto.getId())
                .name(findGoodsDto.getName())
                .intr(findGoodsDto.getIntroduction())
                .goodsPrice(findGoodsDto.getGoodsPrice())
                .creator(findGoodsDto.getCreator())
                .createdAt(findGoodsDto.getCreatedAt())
                .modifier(findGoodsDto.getModifier())
                .modifiedAt(findGoodsDto.getModifiedAt())
                .build();
    }

    public List<GoodsInfoResponseDto> findList(Long sellerId) {
        List<GoodsDto> findGoodsDtoBySellerId = goodsFindService.findList(sellerId);
        return findGoodsDtoBySellerId.stream().map(goodsDto -> GoodsInfoResponseDto.builder()
                        .id(goodsDto.getId())
                        .name(goodsDto.getName())
                        .intr(goodsDto.getIntroduction())
                        .goodsPrice(goodsDto.getGoodsPrice())
                        .creator(goodsDto.getCreator())
                        .createdAt(goodsDto.getCreatedAt())
                        .modifier(goodsDto.getModifier())
                        .modifiedAt(goodsDto.getModifiedAt())
                        .build())
                .collect(Collectors.toList());
    }

    public GoodsSearchResponseDto searchList(GoodsSearchRequestDto goodsSearchRequestDto) {
        List<GoodsDto> searchList = goodsFindService.searchList(GoodsDtoMapper.INSTANCE.map(goodsSearchRequestDto));

        List<GoodsInfoResponseDto> collect = searchList.stream().map(goodsDto -> GoodsInfoResponseDto.builder()
                        .id(goodsDto.getId())
                        .name(goodsDto.getName())
                        .intr(goodsDto.getIntroduction())
                        .goodsPrice(goodsDto.getGoodsPrice())
                        .creator(goodsDto.getCreator())
                        .createdAt(goodsDto.getCreatedAt())
                        .modifier(goodsDto.getModifier())
                        .modifiedAt(goodsDto.getModifiedAt())
                        .build())
                .collect(Collectors.toList());
        return GoodsSearchResponseDto.builder()
                .goodsFindResponseDtoList(collect)
                .totalCount(collect.size())
                .build();
    }
}
