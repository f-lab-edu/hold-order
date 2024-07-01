package com.holdOrder.HoldOrder.domain.goodsOption;

import com.holdOrder.HoldOrder.config.EntityDate;
import com.holdOrder.HoldOrder.domain.goods.Goods;
import com.holdOrder.HoldOrder.dto.goodsOption.GoodsOptionModifyRequestDto;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "goods_option")
@ToString(exclude = "goods")
@EqualsAndHashCode(callSuper = false, of = "id")
public class GoodsOption extends EntityDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
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

    public GoodsOption(GoodsOptionModifyRequestDto goodsOptionModifyRequestDto) {
        this.id = goodsOptionModifyRequestDto.getId();
        this.name = goodsOptionModifyRequestDto.getName();
        this.optionPrice = goodsOptionModifyRequestDto.getOptionPrice();
        this.sort = goodsOptionModifyRequestDto.getSort();
    }
}
