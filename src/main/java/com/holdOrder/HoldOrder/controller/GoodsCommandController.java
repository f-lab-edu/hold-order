package com.holdOrder.HoldOrder.controller;

import com.holdOrder.HoldOrder.service.GoodsCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/goods")
@RequiredArgsConstructor
public class GoodsCommandController {
    private final GoodsCommandService goodsCommandService;



}
