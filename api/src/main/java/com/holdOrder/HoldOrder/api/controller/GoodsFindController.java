package com.holdOrder.HoldOrder.api.controller;

import com.holdOrder.HoldOrder.application.application.GoodsApplication;
import com.holdOrder.HoldOrder.application.dto.goods.GoodsInfoResponseDto;
import com.holdOrder.HoldOrder.application.dto.goods.GoodsSearchRequestDto;
import com.holdOrder.HoldOrder.application.dto.goods.GoodsSearchResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<List<GoodsInfoResponseDto>> findList(@Valid @RequestParam Long sellerId) {
        return new ResponseEntity<>(goodsApplication.findList(sellerId), HttpStatus.OK);
    }

    @PostMapping("/searchList")
    public ResponseEntity<GoodsSearchResponseDto> searchList(@RequestBody GoodsSearchRequestDto goodsSearchRequestDto) {
        return new ResponseEntity<>(goodsApplication.searchList(goodsSearchRequestDto), HttpStatus.OK);
    }

    @PostMapping("/searchList/paging")
    public ResponseEntity<Page<GoodsInfoResponseDto>> searchListWithPageable(@RequestBody GoodsSearchRequestDto goodsSearchRequestDto, Pageable pageable) {
        return new ResponseEntity<>(goodsApplication.searchListWithPageable(goodsSearchRequestDto, pageable), HttpStatus.OK);
    }

}
