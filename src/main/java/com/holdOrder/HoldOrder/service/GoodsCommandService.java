package com.holdOrder.HoldOrder.service;

import com.holdOrder.HoldOrder.domain.goods.GoodsRepository;
import com.holdOrder.HoldOrder.dto.goods.GoodsFindRequestDto;
import com.holdOrder.HoldOrder.dto.goods.GoodsResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsCommandService {

    GoodsRepository goodsRepository;

    @Autowired
    public GoodsCommandService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public GoodsResponseDto modify(GoodsFindRequestDto reqDto) {
        return null;
    }

    public GoodsResponseDto modifyList() {
        return null;
    }

    public GoodsResponseDto remove() {
        return null;
    }
}
