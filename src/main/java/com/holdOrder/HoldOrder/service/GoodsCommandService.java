package com.holdOrder.HoldOrder.service;

import com.holdOrder.HoldOrder.domain.goods.GoodsRepository;
import com.holdOrder.HoldOrder.dto.goods.GoodsRequestDto;
import com.holdOrder.HoldOrder.dto.goods.GoodsResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsCommandService {

    GoodsRepository goodsRepository;

    @Autowired
    public GoodsCommandService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public GoodsResponseDto find(GoodsRequestDto reqDto) {
        return null;
    }

    public GoodsResponseDto findList(List<GoodsRequestDto> reqDtos) {
        return null;
    }

    public GoodsResponseDto modify(GoodsRequestDto reqDto) {
        return null;
    }

    public GoodsResponseDto modifyList() {
        return null;
    }

    public GoodsResponseDto remove() {
        return null;
    }
}
