package com.holdOrder.HoldOrder.core.domain.goods;

import com.holdOrder.HoldOrder.core.dto.goods.GoodsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>, GoodsRepositoryCustom {
    List<Goods> findAllBySellerId(Long id);
}
