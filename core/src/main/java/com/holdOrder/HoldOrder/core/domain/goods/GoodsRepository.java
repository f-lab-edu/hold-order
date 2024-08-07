package com.holdOrder.HoldOrder.core.domain.goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>, GoodsRepositoryCustom {
    List<Goods> findAllBySellerId(Long id);
}
