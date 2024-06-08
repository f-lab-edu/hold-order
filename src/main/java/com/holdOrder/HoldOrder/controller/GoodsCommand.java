package com.holdOrder.HoldOrder.controller;

import com.holdOrder.HoldOrder.service.GoodsCommandService;
import org.springframework.beans.factory.annotation.Autowired;
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



}
