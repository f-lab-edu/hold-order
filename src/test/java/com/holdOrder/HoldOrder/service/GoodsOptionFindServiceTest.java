package com.holdOrder.HoldOrder.service;

import com.holdOrder.HoldOrder.domain.goods.Goods;
import com.holdOrder.HoldOrder.domain.goods.GoodsRepository;
import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOptionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@ActiveProfiles("dev")
//@SpringBootTest
//@Import(value = "")
class GoodsOptionFindServiceTest {

//    @Autowired
//    GoodsOptionRepository goodsOptionRepository;
//
//    @Autowired
//    GoodsRepository goodsRepository;
//
//    @Autowired
//    GoodsOptionFindService goodsOptionFindService;
//
//    private Goods goods;
//
//    @BeforeEach
//    void 테스트_실행_전에_값을_집어넣는다() {
//
//    }
//
//    @Test
//    @Transactional
//    void find() {
//        goods = Goods.builder().id(1L).build();
//
//        goodsRepository.save(goods);
//
//        GoodsOption dummyGoodsOption1 = GoodsOption.builder()
//                .id(1L)
//                .goods(goods)
//                .optionPrice(1000)
//                .name("dummyGoodsOption1")
//                .build();
//        GoodsOption dummyGoodsOption2 = GoodsOption.builder()
//                .id(1L)
//                .goods(goods)
//                .optionPrice(1000)
//                .name("dummyGoodsOption2")
//                .build();
//        GoodsOption dummyGoodsOption3 = GoodsOption.builder()
//                .id(1L)
//                .goods(goods)
//                .optionPrice(1000)
//                .name("dummyGoodsOption3")
//                .build();
//        GoodsOption dummyGoodsOption4 = GoodsOption.builder()
//                .id(1L)
//                .goods(goods)
//                .optionPrice(1000)
//                .name("dummyGoodsOption4")
//                .build();
//
//
//        goodsOptionRepository.save(dummyGoodsOption1);
//        goodsOptionRepository.save(dummyGoodsOption2);
//        goodsOptionRepository.save(dummyGoodsOption3);
//        goodsOptionRepository.save(dummyGoodsOption4);
//        GoodsOption byId = goodsOptionFindService.find(1L);
//        Assertions.assertThat(byId.getOptionPrice()).isEqualTo(1000);
//    }
//
//    @Test
//    void findList() {
//        List<GoodsOption> list = goodsOptionFindService.findList(goods.getId());
//        Assertions.assertThat(list.size()).isGreaterThan(1);
//    }
}