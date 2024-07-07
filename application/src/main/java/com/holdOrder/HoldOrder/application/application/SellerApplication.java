package com.holdOrder.HoldOrder.application.application;

import com.holdOrder.HoldOrder.application.dto.Seller.SellerSaveRequestDto;
import com.holdOrder.HoldOrder.application.dto.Seller.SellerSaveResponseDto;
import com.holdOrder.HoldOrder.application.mapper.SellerDtoMapper;
import com.holdOrder.HoldOrder.core.dto.seller.SellerDto;
import com.holdOrder.HoldOrder.core.service.SellerCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SellerApplication {
    private final SellerCommandService sellerCommandService;

    public SellerSaveResponseDto save(SellerSaveRequestDto inputSeller) {
        SellerDto inputSellerDto = SellerDtoMapper.INSTANCE.map(inputSeller);
        SellerDto insertedSellerDto = sellerCommandService.saveOne(inputSellerDto);
        return SellerSaveResponseDto.builder()
                .name(insertedSellerDto.getName())
                .creator(insertedSellerDto.getCreator())
                .createdAt(insertedSellerDto.getCreatedAt())
                .build();
    }

}
