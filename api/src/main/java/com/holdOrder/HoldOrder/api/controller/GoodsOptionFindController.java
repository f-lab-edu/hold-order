package com.holdOrder.HoldOrder.api.controller;

import com.holdOrder.HoldOrder.application.application.GoodsOptionApplication;
import com.holdOrder.HoldOrder.application.dto.goodsOption.GoodsOptionFindResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/goods-option/find/")
@RequiredArgsConstructor
public class GoodsOptionFindController {
    private final GoodsOptionApplication goodsOptionApplication;

    @GetMapping("/{goodsOptionId}")
    public ResponseEntity<GoodsOptionFindResponseDto> find(@PathVariable Long goodsOptionId) {
        return new ResponseEntity<>(goodsOptionApplication.find(goodsOptionId), HttpStatus.OK);
    }

    @GetMapping("list/{goodsId}")
    public ResponseEntity<List<GoodsOptionFindResponseDto>> findList(@PathVariable Long goodsId) {
        return new ResponseEntity<>(goodsOptionApplication.findList(goodsId), HttpStatus.OK);
    }

}
