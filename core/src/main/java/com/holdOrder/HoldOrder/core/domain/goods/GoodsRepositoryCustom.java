package com.holdOrder.HoldOrder.core.domain.goods;

import com.holdOrder.HoldOrder.core.dto.goods.GoodsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodsRepositoryCustom {
    List<Goods> searchList(GoodsDto goodsDto);
}
