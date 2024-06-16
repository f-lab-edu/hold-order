package com.holdOrder.HoldOrder.domain.goodsOption;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GoodsOptionRepositoryImpl implements GoodsOptionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager entityManager;
    private final QGoodsOption qgoods = QGoodsOption.goodsOption;

    @Override
    public GoodsOption saveGoodsOption(GoodsOption goodsOption) {
        return null;
    }
}
