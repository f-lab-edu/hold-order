package com.holdOrder.HoldOrder.core.service;

import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOptionRepository;
import com.holdOrder.HoldOrder.core.dto.goodsOption.GoodsOptionDto;
import com.holdOrder.HoldOrder.core.mapper.GoodsOptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoodsOptionFindService {
    private final GoodsOptionRepository goodsOptionRepository;

    @Transactional(readOnly = true)
    public GoodsOptionDto find(Long goodsOptionId) {
        GoodsOption goodsOption = goodsOptionRepository.findById(goodsOptionId).orElseThrow(() -> new NoSuchElementException("굿즈 " + goodsOptionId + "는 존재하지 않습니다."));
        return GoodsOptionMapper.INSTANCE.map(goodsOption);
    }

    @Transactional(readOnly = true)
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
