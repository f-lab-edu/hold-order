package com.holdOrder.HoldOrder.core.mapper;

import com.holdOrder.HoldOrder.core.domain.seller.Seller;
import com.holdOrder.HoldOrder.core.dto.seller.SellerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SellerMapper {
    SellerMapper INSTANCE = Mappers.getMapper(SellerMapper.class);

    SellerDto map(Seller seller);

    Seller map(SellerDto sellerDto);
}
