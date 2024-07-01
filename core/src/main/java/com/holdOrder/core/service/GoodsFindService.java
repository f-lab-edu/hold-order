package com.holdOrder.core.service;

import com.holdOrder.core.dto.goods.GoodsFindRequestDto;
import com.holdOrder.core.dto.goods.GoodsInfoResponseDto;
import com.holdOrder.core.dto.goods.GoodsResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;

@Service
public class GoodsFindService {
    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public GoodsFindService(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Transactional(readOnly = true)
    public GoodsInfoResponseDto find(Long id) {
        return null;
    }

    public GoodsResponseDto findList(GoodsFindRequestDto goodsFindRequestDto, Pageable pageable) {
        return null;
    }

}
