package com.holdOrder.HoldOrder.service;

import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOptionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;


@ActiveProfiles("dev")
@SpringBootTest
class GoodsOptionCommandServiceTest {

    @Autowired
    GoodsOptionCommandService goodsOptionCommandService;

    @Autowired
    GoodsOptionRepository goodsOptionRepository;

    @Test
    @Rollback(value = false)
    void GoodsOption_값이_없을_때는_sort값이_1로_설정되면서_저장된다() throws InterruptedException {
        // given
        GoodsOption dummyGoodsOption1 = GoodsOption.builder()
                .id(1L)
                .name("DummyGoodsOptionName1")
                .optionPrice(1000)
                .build();
        GoodsOption dummyGoodsOption2 = GoodsOption.builder()
                .id(1L)
                .name("DummyGoodsOptionName2")
                .optionPrice(1000)
                .build();
        GoodsOption dummyGoodsOption3 = GoodsOption.builder()
                .id(1L)
                .name("DummyGoodsOptionName3")
                .optionPrice(1000)
                .build();
        GoodsOption dummyGoodsOption4 = GoodsOption.builder()
                .id(1L)
                .name("DummyGoodsOptionName4")
                .optionPrice(1000)
                .build();

        // when
        GoodsOption save1 = goodsOptionRepository.save(dummyGoodsOption1);
        GoodsOption save2 = goodsOptionRepository.save(dummyGoodsOption2);
        GoodsOption save3 = goodsOptionRepository.save(dummyGoodsOption3);
        GoodsOption save4 = goodsOptionRepository.save(dummyGoodsOption4);

        // then
        Assertions.assertThat(save4.getSort()).isEqualTo(4); // TODO 왜 4가 아니라 1이 뜰까

        System.out.println(save4.getSort());

    }


    @Test
    void modify() {
        // given
        GoodsOption dummyGoodsOption1 = GoodsOption.builder()
                .id(1L)
                .name("DummyGoodsOptionName1")
                .optionPrice(1000)
                .build();
        GoodsOption dummyGoodsOption2 = GoodsOption.builder()
                .id(1L)
                .name("DummyGoodsOptionName2")
                .optionPrice(1000)
                .build();
        GoodsOption dummyGoodsOption3 = GoodsOption.builder()
                .id(1L)
                .name("DummyGoodsOptionName3")
                .optionPrice(1000)
                .build();
        GoodsOption dummyGoodsOption4 = GoodsOption.builder()
                .id(1L)
                .name("DummyGoodsOptionName4")
                .optionPrice(1000)
                .build();

        // when
        goodsOptionRepository.save(dummyGoodsOption1);
        goodsOptionRepository.save(dummyGoodsOption2);
        goodsOptionRepository.save(dummyGoodsOption3);
        GoodsOption save = goodsOptionRepository.save(dummyGoodsOption4);

        // then
        Assertions.assertThat(goodsOptionRepository.findById(save.getId()).orElseThrow().getName()).isEqualTo("DummyGoodsOptionName4");

    }

    @Test
    void remove() {
    }
}