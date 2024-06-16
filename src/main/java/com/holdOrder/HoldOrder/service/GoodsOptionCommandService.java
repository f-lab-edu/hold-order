package com.holdOrder.HoldOrder.service;

import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOptionRepository;
import com.holdOrder.HoldOrder.dto.goodsOption.GoodsOptionModifyResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsOptionCommandService {

    private final GoodsOptionRepository goodsOptionRepository;

    @Autowired
    public GoodsOptionCommandService(GoodsOptionRepository goodsOptionRepository) {
        this.goodsOptionRepository = goodsOptionRepository;
    }

    @Transactional
    public GoodsOptionModifyResponseDto modify(GoodsOption goodsOption) {
        GoodsOption savedGoodsOption = goodsOptionRepository.save(goodsOption);
        return new GoodsOptionModifyResponseDto(savedGoodsOption);
    }

    @Transactional
    public boolean remove(List<GoodsOption> goodsOptionList) {
        try {
            goodsOptionRepository.deleteAll(goodsOptionList);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("알맞지 않은 argument입니다");
        }
        return true;
    }

}
