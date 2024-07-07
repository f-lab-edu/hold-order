package com.holdOrder.HoldOrder.applicationTest.testService;

import com.holdOrder.HoldOrder.core.domain.seller.Seller;
import com.holdOrder.HoldOrder.core.domain.seller.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestSellerFindService {

    private final SellerRepository sellerRepository;

    @Autowired
    public TestSellerFindService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Transactional(readOnly = true)
    public Seller find(Long id) {
        return sellerRepository.findById(id).orElseThrow();
    }
}
