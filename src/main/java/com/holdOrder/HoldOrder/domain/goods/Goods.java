package com.holdOrder.HoldOrder.domain.goods;

import com.holdOrder.HoldOrder.config.EntityDate;
import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.domain.seller.Seller;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "GOODS")
@SQLRestriction("DELETED_YN = false")
public class Goods extends EntityDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GOODS_ID")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SELLER_ID")
    private Seller seller;
    @Column(name = "NAME")
    private String name; // 굿즈명
    @Column(name = "INTR")
    private String intr; // 굿즈 소개글
    @Column(name = "GOODS_IMG_URL")
    private String goodsImgUrl; // 굿즈 이미지
    @Column(name = "GOODS_PRICE")
    private Integer goodsPrice; // 굿즈 가격(총 가격 = 옵션가격 총합 + 굿즈가격)
    @Column(name = "USED_YN")
    private Boolean usedYn; // 상품 개시여부
    @Column(name = "DELETED_YN")
    private Boolean deletedYn; // 삭제여부. false = 삭제안됨, true = 삭제됨
    @OneToMany(mappedBy = "goods")
    private List<GoodsOption> goodsOptions = new ArrayList<>();

    @Builder
    public Goods(Seller seller, String name, String intr, String goodsImgUrl, Integer goodsPrice, Boolean usedYn, Boolean deletedYn, List<GoodsOption> goodsOptions) {
        this.seller = seller;
        this.name = name;
        this.intr = intr;
        this.goodsImgUrl = goodsImgUrl;
        this.goodsPrice = goodsPrice;
        this.usedYn = usedYn;
        this.deletedYn = deletedYn;
        this.goodsOptions = goodsOptions;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Goods) {
            return this.id.equals(((Goods) obj).getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() { // TODO
        return "Goods{" +
                "id='" + id + '\'' +
                ", seller=" + seller +
                ", name='" + name + '\'' +
                ", intr='" + intr + '\'' +
                ", goodsImgUrl='" + goodsImgUrl + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", usedYn=" + usedYn +
                ", deletedYn=" + deletedYn +
                ", goodsOptions=" + goodsOptions +
                '}';
    }
}