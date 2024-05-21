package com.holdOrder.HoldOrder.domain.goods;

import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.domain.seller.Seller;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "GOODS")
@EntityListeners(AuditingEntityListener.class)
public class Goods {
    @Id
    private String goodsId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SELLER_ID")
    private Seller sellerId;
    private String goodsNm; // 굿즈명
    private String intr; // 굿즈 소개글
    private String goodsImgUrl; // 굿즈 이미지
    private int goodsPrice; // 굿즈 가격(총 가격 = 옵션가격 총합 + 굿즈가격)
    private boolean usedYn; // 상품 개시여부
    private boolean deleYn; // 삭제여부
    @CreatedDate
    private Timestamp regiDt;
    @OneToMany(mappedBy = "goods")
    private List<GoodsOption> goodsOptions = new ArrayList<>();

    @Builder
    public Goods(String goodsId, Seller sellerId, String goodsNm, String intr, String goodsImgUrl, int goodsPrice, boolean usedYn, boolean deleYn, Timestamp regiDt, List<GoodsOption> goodsOptions) {
        this.goodsId = goodsId;
        this.sellerId = sellerId;
        this.goodsNm = goodsNm;
        this.intr = intr;
        this.goodsImgUrl = goodsImgUrl;
        this.goodsPrice = goodsPrice;
        this.usedYn = usedYn;
        this.deleYn = deleYn;
        this.regiDt = regiDt;
        this.goodsOptions = goodsOptions;
    }
}