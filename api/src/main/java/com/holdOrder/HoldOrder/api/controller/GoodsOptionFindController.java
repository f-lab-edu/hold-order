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

@RestController
@RequestMapping("/v1/goods-option/find/")
@RequiredArgsConstructor
public class GoodsOptionFindController {
    private final GoodsOptionApplication goodsOptionApplication;

    @GetMapping("/{id}")
    public ResponseEntity<GoodsOptionFindResponseDto> find(@PathVariable Long id) {
        return new ResponseEntity<>(goodsOptionApplication.find(id), HttpStatus.OK);
    }
}
