package com.holdOrder.HoldOrder.domain.goodsOption;

import com.holdOrder.HoldOrder.config.EntityDate;
import com.holdOrder.HoldOrder.domain.goods.Goods;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "GOODS_OPTION")
public class GoodsOption extends EntityDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_ID")
    private Long id;
    @Column(name = "GOODS_ID")
    private String goodsId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "OPTION_PRICE")
    private Integer optionPrice;
    @Column(name = "SORT")
    private Integer sort; // 옵션 정렬 순서
    @ManyToOne(fetch = FetchType.LAZY)
    private Goods goods;

    @Builder
    public GoodsOption(String goodsId, String name, Integer optionPrice, Integer sort, Goods goods) {
        this.goodsId = goodsId;
        this.name = name;
        this.optionPrice = optionPrice;
        this.sort = sort;
        this.goods = goods;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GoodsOption) {
            return this.id.equals(((GoodsOption) obj).getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() { // TODO
        return "GoodsOption{" +
                "id='" + id + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", name='" + name + '\'' +
                ", optionPrice=" + optionPrice +
                ", sort=" + sort +
                ", goods=" + goods +
                '}';
    }
}
