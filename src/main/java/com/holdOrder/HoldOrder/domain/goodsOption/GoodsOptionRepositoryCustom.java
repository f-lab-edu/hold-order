package com.holdOrder.HoldOrder.domain.goodsOption;

import java.util.List;

public interface GoodsOptionRepositoryCustom {
    List<GoodsOption> findAllByGoodsId(Long goodsId);
    Integer findTopByGoodsIdOrderBySortDesc(Long goodsId);

    Long findGoodsIdByGoodsOptionId(Long id);
}
