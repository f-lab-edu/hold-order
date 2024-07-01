package com.holdOrder.HoldOrder.domain.goodsOption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GoodsOptionRepository extends JpaRepository<GoodsOption, Long>, GoodsOptionRepositoryCustom {

    List<GoodsOption> findAllByGoodsId(Long goodsId);
    Integer findTopByGoodsIdOrderBySortDesc(Long goodsId);
}
