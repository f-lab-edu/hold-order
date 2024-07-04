package com.holdOrder.HoldOrder.core.domain.goods;

import com.holdOrder.HoldOrder.core.config.EntityDate;
import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.core.domain.seller.Seller;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "goods")
@SQLRestriction("deleted_yn = false")
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
public class Goods extends EntityDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    @ToString.Exclude
    private Seller seller;
    @Column(name = "name")
    private String name; // 굿즈명
    @Column(name = "intr")
    private String introduction; // 굿즈 소개글
    @Column(name = "goods_img_url")
    private String goodsImageUrl; // 굿즈 이미지
    @Column(name = "goods_price")
    private Integer goodsPrice; // 굿즈 가격(총 가격 = 옵션가격 총합 + 굿즈가격)
    @Column(name = "used_yn")
    private Boolean usedYn; // 상품 개시여부
    @Column(name = "deleted_yn")
    private Boolean deletedYn; // 삭제여부. false = 삭제안됨, true = 삭제됨
    @OneToMany(mappedBy = "goods")
    @ToString.Exclude
    private List<GoodsOption> goodsOptions = new ArrayList<>();

    @Builder
    public Goods(Long id, Seller seller, String name, String introduction, String goodsImageUrl, Integer goodsPrice, Boolean usedYn, Boolean deletedYn, List<GoodsOption> goodsOptions) {
        this.id = id;
        this.seller = seller;
        this.name = name;
        this.introduction = introduction;
        this.goodsImageUrl = goodsImageUrl;
        this.goodsPrice = goodsPrice;
        this.usedYn = usedYn;
        this.deletedYn = deletedYn;
        this.goodsOptions = goodsOptions;
    }
}