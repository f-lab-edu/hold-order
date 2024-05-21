package com.holdOrder.HoldOrder.service;


import com.holdOrder.HoldOrder.dto.goods.GoodsRespDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsSearchService {
    public GoodsRespDto searchOne();

    public List<GoodsRespDto> searchList();

}
