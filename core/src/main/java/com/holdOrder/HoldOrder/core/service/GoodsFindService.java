package com.holdOrder.HoldOrder.core.service;

import com.holdOrder.HoldOrder.core.domain.goods.Goods;
import com.holdOrder.HoldOrder.core.domain.goods.GoodsRepository;
import com.holdOrder.HoldOrder.core.dto.goods.GoodsDto;
import com.holdOrder.HoldOrder.core.mapper.GoodsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GoodsFindService {
    private final GoodsRepository goodsRepository;

    @Transactional(readOnly = true)
    public GoodsDto find(Long id) {
        Goods findGoods = goodsRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("값이 존재하지 않습니다");
        });

        return GoodsMapper.INSTANCE.map(findGoods);
    }

    @Transactional(readOnly = true)
    public List<GoodsDto> findList(Long sellerId) {
        List<Goods> findGoodsBySellerId = goodsRepository.findAllBySellerId(sellerId);
        return GoodsMapper.INSTANCE.map(findGoodsBySellerId);
    }

    @Transactional(readOnly = true)
    public List<GoodsDto> searchList(GoodsDto goodsDto) {
        List<Goods> searchList = goodsRepository.searchList(goodsDto);
        return GoodsMapper.INSTANCE.map(searchList);
    }

    @Transactional(readOnly = true)
    public Page<GoodsDto> searchListWithPageable(GoodsDto goodsDto, Pageable pageable) {
        Page<Goods> goodsPage = goodsRepository.searchListWithPageable(goodsDto, pageable);
        return new PageImpl<>(GoodsMapper.INSTANCE.map(goodsPage.getContent()), pageable, goodsPage.getTotalElements());
    }
}
