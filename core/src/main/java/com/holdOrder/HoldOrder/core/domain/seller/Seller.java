package com.holdOrder.HoldOrder.core.domain.seller;

import com.holdOrder.HoldOrder.core.domain.goods.Goods;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "seller")
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Goods> goodsList = new ArrayList<>();

    @Builder
    public Seller(Long id, String name, List<Goods> goodsList) {
        this.id = id;
        this.name = name;
        this.goodsList = goodsList;
    }
}
