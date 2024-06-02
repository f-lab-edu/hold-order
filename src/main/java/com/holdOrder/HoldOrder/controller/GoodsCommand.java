package com.holdOrder.HoldOrder.controller;

import com.holdOrder.HoldOrder.dto.goods.GoodsRequestDto;
import com.holdOrder.HoldOrder.dto.goods.GoodsResponseDto;
import com.holdOrder.HoldOrder.service.GoodsCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/goods")
public class GoodsCommand {

    private final GoodsCommandService goodsCommandService;

    @Autowired
    public GoodsCommand(GoodsCommandService goodsCommandService) {
        this.goodsCommandService = goodsCommandService;
    }

    @GetMapping("/")
    public ResponseEntity<GoodsResponseDto> find(GoodsRequestDto goodsRequestDto) {
        return new ResponseEntity<>(goodsCommandService.find(goodsRequestDto), HttpStatus.OK);
    }



}
