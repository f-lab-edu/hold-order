package com.holdOrder.HoldOrder.domain.seller;

import com.holdOrder.HoldOrder.config.EntityDate;
import com.holdOrder.HoldOrder.domain.goods.Goods;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "seller")
@EqualsAndHashCode(callSuper = false, of = "id")
public class Seller extends EntityDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    private List<Goods> goodsList = new ArrayList<>();

    @Builder
    public Seller(String name, List<Goods> goodsList) {
        this.name = name;
        this.goodsList = goodsList;
    }

    @Override
    public String toString() { // TODO
        return "Seller{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }
}
