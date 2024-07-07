package com.holdOrder.HoldOrder.api.controller;

import com.holdOrder.HoldOrder.application.application.GoodsApplication;
import com.holdOrder.HoldOrder.application.dto.goods.GoodsSaveRequestDto;
import com.holdOrder.HoldOrder.application.dto.goods.GoodsSaveResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/goods")
@RequiredArgsConstructor
public class GoodsCommandController {
    private final GoodsApplication goodsApplication;

    @PostMapping("/save")
    public ResponseEntity<GoodsSaveResponseDto> save(GoodsSaveRequestDto goodsSaveRequestDto) {
        return new ResponseEntity<>(goodsApplication.save(goodsSaveRequestDto), HttpStatus.OK);
    }

}
