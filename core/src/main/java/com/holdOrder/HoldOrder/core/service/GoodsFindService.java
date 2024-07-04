package com.holdOrder.HoldOrder.core.service;

import com.holdOrder.HoldOrder.core.domain.goods.GoodsRepository;
import com.holdOrder.HoldOrder.core.dto.goods.GoodsFindRequestDto;
import com.holdOrder.HoldOrder.core.dto.goods.GoodsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GoodsFindService {
    private final GoodsRepository goodsRepository;

    @Transactional(readOnly = true)
    public GoodsDto find(Long id) {
        goodsRepository.findById(id).orElseThrow(() -> { throw new NoSuchElementException("값이 존재하지 않습니다"); });

        return null;
    }

    public List<GoodsDto> findList(GoodsFindRequestDto goodsFindRequestDto, Pageable pageable) {
        return null;
    }

}
