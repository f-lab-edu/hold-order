package com.holdOrder.HoldOrder.service;

import com.holdOrder.HoldOrder.dto.goods.GoodsReqDto;
import com.holdOrder.HoldOrder.dto.goods.GoodsRespDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface GoodsCUDService {

    public GoodsRespDto insertGoods(@RequestBody GoodsReqDto reqDto);

    public GoodsRespDto insertGoodsList(@RequestBody List<GoodsReqDto> reqDtos);

    public GoodsRespDto modifyGoods(@RequestBody GoodsReqDto reqDto);

    public GoodsRespDto modifyGoodsBulk();

    public GoodsRespDto removeGoods();
}
