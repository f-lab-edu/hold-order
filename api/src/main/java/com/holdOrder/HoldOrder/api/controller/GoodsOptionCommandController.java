package com.holdOrder.HoldOrder.api.controller;

import com.holdOrder.HoldOrder.application.dto.goods.GoodsResponseDto;
import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.application.dto.goodsOption.GoodsOptionModifyResponseDto;
import com.holdOrder.HoldOrder.core.dto.goodsOption.GoodsOptionSaveRequestDto;
import com.holdOrder.HoldOrder.core.dto.goodsOption.GoodsOptionModifyRequestDto;
import com.holdOrder.HoldOrder.core.service.GoodsOptionCommandService;
import lombok.RequiredArgsConstructor;
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
        return null;
//        return new ResponseEntity<>(goodsOptionCommandService.saveWithSort(goodsOptionSaveRequestDto), HttpStatus.OK);
    }

    @PostMapping("/modifiy")
    public ResponseEntity<GoodsOptionModifyResponseDto> modify(GoodsOptionModifyRequestDto goodsOptionModifyRequestDto) {
        return null;
//        return new ResponseEntity<>(goodsOptionCommandService.modify(goodsOptionModifyRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> remove(Long id) {
        return null;
//        goodsOptionCommandService.remove(id);
//        return new ResponseEntity<>(HttpStatus.OK);
    }
}
