package com.holdOrder.HoldOrder.core.service;

import com.holdOrder.HoldOrder.core.domain.goods.Goods;
import com.holdOrder.HoldOrder.core.domain.goods.GoodsRepository;
import com.holdOrder.HoldOrder.core.dto.goods.GoodsDto;
import com.holdOrder.HoldOrder.core.mapper.GoodsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsCommandService {
    private final GoodsRepository goodsRepository;

    @Transactional
    public GoodsDto save(GoodsDto insertedGoodsDto) {
        Goods insertedGoods = GoodsMapper.INSTANCE.goodsDtoToGoods(insertedGoodsDto);
        insertedGoods.setDeletedYn(false);
        insertedGoods.setUsedYn(false);

        return GoodsMapper.INSTANCE.goodsToGoodsDto(goodsRepository.save(insertedGoods));
    }

    @Transactional
    public GoodsDto modify(GoodsDto goodsDto) {
        return null;
    }

    @Transactional
    public GoodsDto modifyList(List<GoodsDto> goodsDtoList) {
        return null;
    }

    @Transactional
    public GoodsDto remove(Long goodsId) {
        return null;
    }
}
