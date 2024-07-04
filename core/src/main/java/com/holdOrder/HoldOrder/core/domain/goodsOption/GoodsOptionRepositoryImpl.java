package com.holdOrder.HoldOrder.core.domain.goodsOption;

import com.holdOrder.HoldOrder.core.domain.goods.QGoods;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GoodsOptionRepositoryImpl implements GoodsOptionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QGoodsOption qGoodsOption = QGoodsOption.goodsOption;
    private final QGoods qGoods = QGoods.goods;

    @Override
    public List<GoodsOption> findAllByGoodsId(Long goodsId) {
        return jpaQueryFactory
                .selectFrom(qGoodsOption)
                .where(qGoodsOption.id.eq(goodsId))
                .fetch();
    }

    @Override
    public Integer findTopByGoodsIdOrderBySortDesc(Long goodsId) {
        return jpaQueryFactory
                .select(qGoodsOption.sort)
                .from(qGoodsOption)
                .where(qGoodsOption.id.eq(goodsId))
                .orderBy(qGoodsOption.sort.desc())
                .limit(1)
                .fetchOne();
    }

    @Override
    public Long findGoodsIdByGoodsOptionId(Long id) {
        GoodsOption goodsOption = jpaQueryFactory
                .select(qGoodsOption)
                .from(qGoodsOption)
                .where(qGoodsOption.id.eq(id))
                .fetchOne();

        return goodsOption.getGoods().getId();
    }
}
