package com.holdOrder.HoldOrder.application.application;

import com.holdOrder.HoldOrder.core.domain.seller.Seller;
import com.holdOrder.HoldOrder.core.dto.seller.SellerDto;
import com.holdOrder.HoldOrder.core.mapper.SellerMapper;
import com.holdOrder.HoldOrder.core.service.SellerCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SellerApplication {
    private final SellerCommandService sellerCommandService;

    public Seller save(Seller inputSeller) {
        SellerDto inputSellerDto = SellerMapper.INSTANCE.sellerToSellerDto(inputSeller);
        SellerDto insertedSellerDto = sellerCommandService.saveOne(inputSellerDto);
        return SellerMapper.INSTANCE.sellerDtoToSeller(insertedSellerDto);
    }

}
