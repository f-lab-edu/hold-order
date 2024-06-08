package com.holdOrder.HoldOrder.applicationTest;

import com.holdOrder.HoldOrder.domain.goods.Goods;
import com.holdOrder.HoldOrder.domain.seller.Seller;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Deprecated
public class JpaTest {

    @Autowired
    EntityManager entityManager;


    @Test
    @Transactional
    public void JPA가_제대로_동작하는지_확인() {
        // given
        Seller dummySeller = new Seller("sellerNmA", null);
        entityManager.persist(dummySeller);

        Goods dummyGoods = new Goods(dummySeller, "goodsNmA", "goodsIntrA", "url", 1000, true, false, null);
        entityManager.persist(dummyGoods);


        // when
        entityManager.flush();
        entityManager.clear();

        Seller searchSeller = entityManager.createQuery("select seller from Seller seller where seller.id = 1", Seller.class).getSingleResult();
        Goods searchGoods = entityManager.createQuery("select goods from Goods goods where goods.id = 1", Goods.class).getSingleResult();

        // then
        Assertions.assertThat(searchSeller).isNotNull();
        Assertions.assertThat(searchGoods).isNotNull();


    }
}
