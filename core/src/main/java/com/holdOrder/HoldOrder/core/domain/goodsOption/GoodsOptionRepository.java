package com.holdOrder.HoldOrder.core.domain.goodsOption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;


@Repository
public interface GoodsOptionRepository extends JpaRepository<GoodsOption, Long>, GoodsOptionRepositoryCustom {

    List<GoodsOption> findAllByGoodsId(Long goodsId);
    Integer findTopByGoodsIdOrderBySortDesc(Long goodsId);
    Long findGoodsIdById(Long id);
}
