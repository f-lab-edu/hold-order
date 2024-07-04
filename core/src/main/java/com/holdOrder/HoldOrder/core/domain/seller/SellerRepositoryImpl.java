package com.holdOrder.HoldOrder.core.domain.seller;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SellerRepositoryImpl implements SellerRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QSeller qSeller = QSeller.seller;


}
