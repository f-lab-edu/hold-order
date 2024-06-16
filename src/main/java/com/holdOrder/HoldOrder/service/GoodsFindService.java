package com.holdOrder.HoldOrder.service;

import com.holdOrder.HoldOrder.domain.goods.Goods;
import com.holdOrder.HoldOrder.dto.goods.GoodsInfoResponseDto;
import com.holdOrder.HoldOrder.dto.goods.GoodsResponseDto;
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
//        QGoods goods = QGoods.goods;
//        Goods goodsResult = jpaQueryFactory.selectFrom(goods)
//                .where(goods.id.eq(id))
//                .fetchOne();
//
//        if (goodsResult == null) throw new NoSuchElementException("굿즈가 존재하지 않습니다.");
//
//        return new GoodsInfoResponseDto(goodsResult);
        return null;
    }

    public GoodsResponseDto findList(Goods goodsReqDto, Pageable pageable) {
        return null;
    }

}
