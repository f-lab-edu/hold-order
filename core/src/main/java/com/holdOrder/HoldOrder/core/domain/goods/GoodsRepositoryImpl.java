package com.holdOrder.HoldOrder.core.domain.goods;

import com.holdOrder.HoldOrder.core.domain.seller.QSeller;
import com.holdOrder.HoldOrder.core.dto.goods.GoodsDto;
import com.holdOrder.HoldOrder.core.util.Utility;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GoodsRepositoryImpl implements GoodsRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QGoods qGoods = QGoods.goods;
    private final QSeller qSeller = QSeller.seller;

    @Override
    public List<Goods> searchList(GoodsDto goodsDto) {
        BooleanBuilder builder = new BooleanBuilder();
        JPAQuery<Goods> query = jpaQueryFactory.select(qGoods).from(qGoods);

        if (!StringUtils.isBlank(goodsDto.getNameLike())) {
            builder.and(qGoods.name.contains(goodsDto.getNameLike()));
        }

        if (!StringUtils.isBlank(goodsDto.getSellerNameLike())) {
            query.innerJoin(qGoods.seller, qSeller)
                    .where(qSeller.name.contains(goodsDto.getSellerNameLike())); // '%%'
        }

        if (!Utility.isEmpty(goodsDto.getGoodsPriceTo())) {
            builder.and(qGoods.goodsPrice.goe(goodsDto.getGoodsPriceFrom()));
        }

        if (!Utility.isEmpty(goodsDto.getGoodsPriceFrom())) {
            builder.and(qGoods.goodsPrice.loe(goodsDto.getGoodsPriceTo()));
        }

        if (!Utility.isEmpty(goodsDto.getCreatedAtFrom())) {
            builder.and(qGoods.createdAt.goe(goodsDto.getCreatedAtFrom()));
        }

        if (!Utility.isEmpty(goodsDto.getCreatedAtFrom())) {
            builder.and(qGoods.createdAt.loe(goodsDto.getCreatedAtTo()));
        }

        return query
                .where(builder
                        .and(qGoods.usedYn.eq(GoodsUsedState.Y))
                )
                .offset(goodsDto.getPageSize() * goodsDto.getPageIndex())
                .limit(goodsDto.getPageSize().longValue())
                .orderBy(qGoods.createdAt.desc())
                .fetch();
    }
}
