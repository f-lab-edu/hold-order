package com.holdOrder.HoldOrder.core.domain.goodsOption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface GoodsOptionRepository extends JpaRepository<GoodsOption, Long>, GoodsOptionRepositoryCustom {

    List<GoodsOption> findAllByGoodsId(Long goodsId);
    Integer findTopByGoodsIdOrderBySortDesc(Long goodsId);

    Optional<GoodsOption> findById(Long goodsOptionId);

    @Query("SELECT go.goods.id FROM GoodsOption go WHERE go.id = :id")
    Long findGoodsIdById(@Param("id") Long id);
}
