package com.holdOrder.HoldOrder.controller;

import com.holdOrder.HoldOrder.dto.goods.GoodsFindRequestDto;
import com.holdOrder.HoldOrder.dto.goods.GoodsInfoResponseDto;
import com.holdOrder.HoldOrder.dto.goods.GoodsResponseDto;
import com.holdOrder.HoldOrder.service.GoodsFindService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.print.Pageable;

@Controller
public class GoodsFindController {

    private final GoodsFindService goodsFindService;

    @Autowired
    public GoodsFindController(GoodsFindService goodsFindService) {
        this.goodsFindService = goodsFindService;
    }

    @GetMapping("/find/{id}") // TODO
    public ResponseEntity<GoodsInfoResponseDto> find(@PathVariable Long id) {
        return new ResponseEntity<>(goodsFindService.find(id), HttpStatus.OK);
    }

    @PostMapping("/findList") // TODO
    public ResponseEntity<GoodsResponseDto> findList(@Valid GoodsFindRequestDto goodsFindRequestDto, Pageable pageable) {
        return new ResponseEntity<>(goodsFindService.findList(goodsFindRequestDto, pageable), HttpStatus.OK);
    }
}
