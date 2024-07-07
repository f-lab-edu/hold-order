package com.holdOrder.HoldOrder.api.controller;

import com.holdOrder.HoldOrder.application.application.GoodsOptionApplication;
import com.holdOrder.HoldOrder.application.dto.goodsOption.GoodsOptionModifyResponseDto;
import com.holdOrder.HoldOrder.application.dto.goodsOption.GoodsOptionSaveRequestDto;
import com.holdOrder.HoldOrder.application.dto.goodsOption.GoodsOptionModifyRequestDto;
import com.holdOrder.HoldOrder.application.dto.goodsOption.GoodsOptionSaveResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/goods-option")
@RequiredArgsConstructor
public class GoodsOptionCommandController {
    private final GoodsOptionApplication goodsOptionApplication;

    @PostMapping("/save")
    public ResponseEntity<GoodsOptionSaveResponseDto> saveWithSort(@RequestBody GoodsOptionSaveRequestDto goodsOptionSaveRequestDto) {
        return new ResponseEntity<>(goodsOptionApplication.saveWithSort(goodsOptionSaveRequestDto), HttpStatus.OK);
    }

    @PostMapping("/modify")
    public ResponseEntity<GoodsOptionModifyResponseDto> modify(@RequestBody GoodsOptionModifyRequestDto goodsOptionModifyRequestDto) {
        return new ResponseEntity<>(goodsOptionApplication.modify(goodsOptionModifyRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> remove(Long id) {
        goodsOptionApplication.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
