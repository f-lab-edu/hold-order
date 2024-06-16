package com.holdOrder.HoldOrder.domain.goodsOption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface GoodsOptionRepository extends JpaRepository<GoodsOption, Long>, GoodsOptionRepositoryCustom {

    Optional<GoodsOption> findTopByIdOrderBySortDesc(Long id);

}
