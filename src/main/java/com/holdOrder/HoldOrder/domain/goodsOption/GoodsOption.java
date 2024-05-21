package com.holdOrder.HoldOrder.domain.goodsOption;

import com.holdOrder.HoldOrder.domain.goods.Goods;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "GOODS_OPTION")
@EntityListeners(AuditingEntityListener.class)
public class GoodsOption {
    @Id
    private String optionId;

    private String goodsId;

    private String optionNm;

    private int optionPrice;

    private int sort; // 옵션 정렬 순서

    @CreatedDate
    private Timestamp regiDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GOODS_ID")
    private Goods goods;

    @Builder
    public GoodsOption(String optionId, String goodsId, String optionNm, int optionPrice, int sort, Timestamp regiDt, Goods goods) {
        this.optionId = optionId;
        this.goodsId = goodsId;
        this.optionNm = optionNm;
        this.optionPrice = optionPrice;
        this.sort = sort;
        this.regiDt = regiDt;
        this.goods = goods;
    }
}
