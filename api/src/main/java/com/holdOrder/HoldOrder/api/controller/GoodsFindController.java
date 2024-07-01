package com.holdOrder.HoldOrder.api.controller;

import com.holdOrder.core.dto.goods.GoodsFindRequestDto;
import com.holdOrder.core.dto.goods.GoodsInfoResponseDto;
import com.holdOrder.core.dto.goods.GoodsResponseDto;
import com.holdOrder.core.service.GoodsFindService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/v1/goods/find/")
@RequiredArgsConstructor
public class GoodsFindController {
    private final GoodsFindService goodsFindService;

    @GetMapping("/{id}")
    public ResponseEntity<GoodsInfoResponseDto> find(@PathVariable Long id) {
        return new ResponseEntity<>(goodsFindService.find(id), HttpStatus.OK);
    }

    @PostMapping("/list")
    public ResponseEntity<GoodsResponseDto> findList(@Valid GoodsFindRequestDto goodsFindRequestDto, Pageable pageable) {
        return new ResponseEntity<>(goodsFindService.findList(goodsFindRequestDto, pageable), HttpStatus.OK);
    }
}
