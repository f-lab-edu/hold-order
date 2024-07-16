package com.holdOrder.HoldOrder.core.domain.goods;

import com.holdOrder.HoldOrder.core.dto.goods.GoodsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodsRepositoryCustom {
    List<Goods> searchList(GoodsDto goodsDto);

    Page<Goods> searchListWithPageable(GoodsDto goodsDto, Pageable pageable);
}
