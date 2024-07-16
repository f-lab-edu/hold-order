package com.holdOrder.HoldOrder.core.service;


import com.holdOrder.HoldOrder.core.domain.seller.Seller;
import com.holdOrder.HoldOrder.core.domain.seller.SellerRepository;
import com.holdOrder.HoldOrder.core.dto.seller.SellerDto;
import com.holdOrder.HoldOrder.core.mapper.SellerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SellerCommandService {
    private final SellerRepository sellerRepository;

    @Transactional
    public SellerDto saveOne(SellerDto inputSeller) {
        Seller savedSeller = sellerRepository.save(SellerMapper.INSTANCE.map(inputSeller));
        return SellerMapper.INSTANCE.map(savedSeller);
    }
}
