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
@Table(name = "goods_option")
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
    public String toString() {
        return "GoodsOption{" +
                "id=" + id +
                ", goodsId=" + goods.getId() +
                ", name='" + name + '\'' +
                ", optionPrice=" + optionPrice +
                ", sort=" + sort +
                '}';
    }
}
