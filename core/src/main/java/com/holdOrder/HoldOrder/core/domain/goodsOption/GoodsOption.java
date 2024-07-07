package com.holdOrder.HoldOrder.core.domain.goodsOption;

import com.holdOrder.HoldOrder.core.config.EntityDate;
import com.holdOrder.HoldOrder.core.domain.goods.Goods;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "goods_option")
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
public class GoodsOption extends EntityDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    @ToString.Exclude
    private Goods goods;
    @Column(name = "name")
    private String name;
    @Column(name = "option_price")
    private Integer optionPrice; // 옵션 가격
    @Column(name = "sort")
    private Integer sort; // 옵션 정렬 순서

    @Builder
    public GoodsOption(Long id, Goods goods, String name, Integer optionPrice, Integer sort) {
        this.id = id;
        this.goods = goods;
        this.name = name;
        this.optionPrice = optionPrice;
        this.sort = sort;
    }
}
