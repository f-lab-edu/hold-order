package com.holdOrder.HoldOrder.api.controller;

import com.holdOrder.core.domain.goodsOption.GoodsOption;
import com.holdOrder.core.dto.goodsOption.GoodsOptionModifyRequestDto;
import com.holdOrder.core.dto.goodsOption.GoodsOptionModifyResponseDto;
import com.holdOrder.core.dto.goodsOption.GoodsOptionSaveRequestDto;
import com.holdOrder.core.service.GoodsOptionCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/goods-option")
@RequiredArgsConstructor
public class GoodsOptionCommandController {
    private final GoodsOptionCommandService goodsOptionCommandService;

    @PostMapping("/save")
    public ResponseEntity<GoodsOption> saveWithSort(GoodsOptionSaveRequestDto goodsOptionSaveRequestDto) {
        return new ResponseEntity<>(goodsOptionCommandService.saveWithSort(goodsOptionSaveRequestDto), HttpStatus.OK);
    }

    @PostMapping("/modifiy")
    public ResponseEntity<GoodsOptionModifyResponseDto> modify(GoodsOptionModifyRequestDto goodsOptionModifyRequestDto) {
        return new ResponseEntity<>(goodsOptionCommandService.modify(goodsOptionModifyRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> remove(Long id) {
        goodsOptionCommandService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
