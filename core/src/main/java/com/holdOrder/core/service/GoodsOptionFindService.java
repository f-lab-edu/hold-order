package com.holdOrder.core.service;

import com.holdOrder.core.domain.goodsOption.GoodsOption;
import com.holdOrder.core.domain.goodsOption.GoodsOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GoodsOptionFindService {

    private final GoodsOptionRepository goodsOptionRepository;

    public GoodsOption find(Long goodsOptionId) {
        return goodsOptionRepository.findById(goodsOptionId).orElseThrow(() -> new NoSuchElementException("존재하지 않습니다"));
    }

    public List<GoodsOption> findList(Long goodsId) {
        return goodsOptionRepository.findAllByGoodsId(goodsId);
    }
}
