package com.holdOrder.HoldOrder.core.service;

import com.holdOrder.HoldOrder.core.domain.goods.Goods;
import com.holdOrder.HoldOrder.core.domain.goods.GoodsRepository;
import com.holdOrder.HoldOrder.core.dto.goods.GoodsDto;
import com.holdOrder.HoldOrder.core.mapper.GoodsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoodsFindService {
    private final GoodsRepository goodsRepository;
    @Transactional(readOnly = true)
    public GoodsDto find(Long id) {
        Goods findGoods = goodsRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("값이 존재하지 않습니다");
        });

        return GoodsMapper.INSTANCE.goodsToGoodsDto(findGoods);
    }

    public List<GoodsDto> findList(Long sellerId) {
        List<Goods> allBySellerId = goodsRepository.findAllBySellerId(sellerId);

        return allBySellerId.stream().map(GoodsMapper.INSTANCE::goodsToGoodsDto).collect(Collectors.toList());
    }
}
