package com.holdOrder.HoldOrder.api.controller;

import com.holdOrder.HoldOrder.application.application.GoodsApplication;
import com.holdOrder.HoldOrder.application.dto.goods.GoodsInfoResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/goods/find/")
@RequiredArgsConstructor
public class GoodsFindController {
    private final GoodsApplication goodsApplication;

    @GetMapping("/{id}")
    public ResponseEntity<GoodsInfoResponseDto> find(@PathVariable Long id) {
        return new ResponseEntity<>(goodsApplication.find(id), HttpStatus.OK);
    }

    @PostMapping("/list")
    public ResponseEntity<List<GoodsInfoResponseDto>> findList(@Valid Long sellerId) {
        return new ResponseEntity<>(goodsApplication.findList(sellerId), HttpStatus.OK);
    }
}
