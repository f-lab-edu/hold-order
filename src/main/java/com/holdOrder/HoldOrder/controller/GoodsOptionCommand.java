package com.holdOrder.HoldOrder.controller;

import com.holdOrder.HoldOrder.dto.goodsOption.GoodsOptionModifyRequestDto;
import com.holdOrder.HoldOrder.dto.goodsOption.GoodsOptionModifyResponseDto;
import com.holdOrder.HoldOrder.service.GoodsOptionCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GoodsOptionCommand {

    private final GoodsOptionCommandService goodsOptionCommandService;

    @Autowired
    public GoodsOptionCommand(GoodsOptionCommandService goodsOptionCommandService) {
        this.goodsOptionCommandService = goodsOptionCommandService;
    }

    @PostMapping("/")
    public ResponseEntity<GoodsOptionModifyResponseDto> modify(GoodsOptionModifyRequestDto goodsOptionModifyRequestDto) {
        return new ResponseEntity<>(goodsOptionCommandService.modify(goodsOptionModifyRequestDto.toEntity()), HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<Boolean> remove(GoodsOptionRemoveRequestDto goodsOptionRemoveRequestDto) {
        return new ResponseEntity<>(goodsOptionCommandService.remove(goodsOptionRemoveRequestDto.toEntity()), HttpStatus.OK);
    }
}
