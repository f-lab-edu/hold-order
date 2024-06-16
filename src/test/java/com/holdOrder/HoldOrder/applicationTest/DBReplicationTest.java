package com.holdOrder.HoldOrder.applicationTest;

import com.holdOrder.HoldOrder.applicationTest.testService.TestSellerCommandService;
import com.holdOrder.HoldOrder.applicationTest.testService.TestSellerFindService;
import com.holdOrder.HoldOrder.domain.seller.Seller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static java.lang.Long.MAX_VALUE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
public class DBReplicationTest {

    @Autowired
    TestSellerCommandService testSellerCommandService;

    @Autowired
    TestSellerFindService testSellerFindService;

    @Test
    @Transactional
    public void DB_복제가_제대로_이루어졌는지_확인_저장() {
        // given
        Seller dummySeller = Seller.builder()
                .name("testnameA")
                .build();

//        dummySeller.setId(1L);


        // when
        testSellerCommandService.join(dummySeller);
    }

    @Test
    public void DB_복제가_제대로_이루어졌는가_조회() {
        assertThatThrownBy(() -> testSellerFindService.find(MAX_VALUE))
                .isInstanceOf(NoSuchElementException.class);
    }


}
