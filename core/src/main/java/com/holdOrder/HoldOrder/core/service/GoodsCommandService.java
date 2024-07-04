package com.holdOrder.HoldOrder.core.service;

import com.holdOrder.HoldOrder.core.domain.goods.GoodsRepository;
import com.holdOrder.HoldOrder.core.dto.goods.GoodsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoodsCommandService {
    private final GoodsRepository goodsRepository;

    public GoodsDto modify(GoodsDto reqDto) {
        return null;
    }

    public GoodsDto modifyList() {
        return null;
    }

    public GoodsDto remove() {
        return null;
    }
}
