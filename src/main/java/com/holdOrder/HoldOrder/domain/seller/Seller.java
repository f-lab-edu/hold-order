package com.holdOrder.HoldOrder.domain.seller;

import com.holdOrder.HoldOrder.domain.goods.Goods;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "SELLER")
@EntityListeners(AuditingEntityListener.class)
public class Seller {
    @Id
    private String sellerId;

    private String sellerNm;

    @CreatedDate
    private Timestamp regiDt;

    @OneToMany(mappedBy = "sellerId", fetch = FetchType.LAZY)
    @BatchSize(size = 20)
    private List<Goods> goodsList = new ArrayList<>();

    @Builder
    public Seller(String sellerId, String sellerNm, Timestamp regiDt, List<Goods> goodsList) {
        this.sellerId = sellerId;
        this.sellerNm = sellerNm;
        this.regiDt = regiDt;
        this.goodsList = goodsList;
    }
}
