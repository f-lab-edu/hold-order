package com.holdOrder.HoldOrder.core.service;

import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOptionRepository;
import com.holdOrder.HoldOrder.core.dto.goodsOption.GoodsOptionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoodsOptionFindService {

    private final GoodsOptionRepository goodsOptionRepository;

    public GoodsOptionDto find(Long goodsOptionId) {
        GoodsOption goodsOption =  goodsOptionRepository.findById(goodsOptionId).orElseThrow(() -> new NoSuchElementException("굿즈 " + goodsOptionId + "는 존재하지 않습니다."));
        return GoodsOptionDto.builder()
                .id(goodsOption.getId())
                .name(goodsOption.getName())
                .optionPrice(goodsOption.getOptionPrice())
                .sort(goodsOption.getSort())
                .build();
    }

    public List<GoodsOptionDto> findList(Long goodsId) {
        List<GoodsOption> goodsOptionList = goodsOptionRepository.findAllByGoodsId(goodsId);

        return goodsOptionList.stream().map((item) -> GoodsOptionDto.builder()
                .id(item.getId())
                .name(item.getName())
                .optionPrice(item.getOptionPrice())
                .sort(item.getSort())
                .build()).collect(Collectors.toList());
    }
}
