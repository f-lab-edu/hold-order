package com.holdOrder.HoldOrder.core.util;

import com.querydsl.core.types.dsl.PathBuilderFactory;
import com.querydsl.jpa.JPQLQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PagingUtil {
    private final EntityManager entityManager;

    private Querydsl getQuerydsl(Class clazz) {
        return new Querydsl(entityManager, new PathBuilderFactory().create(clazz));
    }

    public <T> PageImpl<T> getPageImpl(Pageable pageable, JPQLQuery<T> query, Class clazz) {    // 2)
        long totalCount = query.fetchCount();
        List<T> results = getQuerydsl(clazz).applyPagination(pageable, query).fetch();
        return new PageImpl<>(results, pageable, totalCount);
    }

}
