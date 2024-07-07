package com.holdOrder.HoldOrder.api.controller;

import com.holdOrder.HoldOrder.application.application.SellerApplication;
import com.holdOrder.HoldOrder.application.dto.Seller.SellerSaveRequestDto;
import com.holdOrder.HoldOrder.application.dto.Seller.SellerSaveResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/seller")
@RequiredArgsConstructor
public class SellerCommandController {
    private final SellerApplication sellerApplication;

    @PostMapping("/save")
    public ResponseEntity<SellerSaveResponseDto> save(SellerSaveRequestDto inputSeller) {
        return new ResponseEntity<>(sellerApplication.save(inputSeller), HttpStatus.OK);
    }
}
