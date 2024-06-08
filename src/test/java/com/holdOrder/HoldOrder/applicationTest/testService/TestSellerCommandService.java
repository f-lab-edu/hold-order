package com.holdOrder.HoldOrder.applicationTest.testService;

import com.holdOrder.HoldOrder.domain.seller.Seller;
import com.holdOrder.HoldOrder.domain.seller.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestSellerCommandService {

    SellerRepository sellerRepository;

    @Autowired
    public TestSellerCommandService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Transactional
    public Seller join(Seller seller) {
        return sellerRepository.save(seller);
    }
}
