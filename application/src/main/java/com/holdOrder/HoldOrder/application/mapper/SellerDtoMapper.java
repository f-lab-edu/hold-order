package com.holdOrder.HoldOrder.application.mapper;

import com.holdOrder.HoldOrder.application.dto.Seller.SellerSaveRequestDto;
import com.holdOrder.HoldOrder.core.dto.seller.SellerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SellerDtoMapper {
    SellerDtoMapper INSTANCE = Mappers.getMapper(SellerDtoMapper.class);

    SellerDto map(SellerSaveRequestDto sellerSaveRequestDto);

}
