package com.holdOrder.HoldOrder.service;

import com.holdOrder.HoldOrder.dto.goodsOption.GoodsOptionRespDto;
import org.springframework.stereotype.Service;

@Service
public interface GoodsOptionSercie {

    public GoodsOptionRespDto insertGoodsOption();

    public GoodsOptionRespDto modifyGoodsOption();

    public GoodsOptionRespDto removeGoodsOption();

}
