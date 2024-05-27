package com.holdOrder.HoldOrder.domain.goodsOption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GoodsOptionRepository extends JpaRepository<GoodsOption, String> {

}
