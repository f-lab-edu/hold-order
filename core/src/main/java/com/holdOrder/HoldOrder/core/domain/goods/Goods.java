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
@SQLRestriction("deleted_yn = 'N'")
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
@Builder
@AllArgsConstructor
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
    @Column(nullable = false, name = "used_yn")
    @Enumerated(EnumType.STRING)
    private GoodsUsedState usedYn;
    @Column(nullable = false, name = "deleted_yn")
    @Enumerated(EnumType.STRING)
    private GoodsDeletedState deletedYn;
    @OneToMany(mappedBy = "goods", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<GoodsOption> goodsOptions = new ArrayList<>();

}