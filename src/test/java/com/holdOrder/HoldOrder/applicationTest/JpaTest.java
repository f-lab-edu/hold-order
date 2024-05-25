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
public class JpaTest {

    @Autowired
    EntityManager entityManager;


    @Test
    @Transactional
    public void JPA가_제대로_동작하는지_확인() {
        // given
        Seller seller = new Seller("sellerIdA", "sellerNmA", null, null);
        entityManager.persist(seller);

        Goods goods = new Goods("goodsIdA", seller, "goodsNmA", "goodsIntrA", "url", 1000, true, false, null, null);
        entityManager.persist(goods);


        // when
        entityManager.flush();
        entityManager.clear();

        Seller searchSeller = entityManager.createQuery("select seller from Seller seller where seller.sellerId = seller.sellerId", Seller.class).getSingleResult();
        Goods searchGoods = entityManager.createQuery("select goods from Goods goods where goods.goodsId = goods.goodsId", Goods.class).getSingleResult();

        // then
        Assertions.assertThat(searchSeller).isNotNull();
        Assertions.assertThat(searchGoods).isNotNull();


    }
}
