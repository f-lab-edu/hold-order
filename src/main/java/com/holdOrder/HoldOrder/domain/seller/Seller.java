package com.holdOrder.HoldOrder.domain.seller;

import com.holdOrder.HoldOrder.config.EntityDate;
import com.holdOrder.HoldOrder.domain.goods.Goods;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "SELLER")
public class Seller extends EntityDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SELLER_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    private List<Goods> goodsList = new ArrayList<>();

    @Builder
    public Seller(String name, List<Goods> goodsList) {
        this.name = name;
        this.goodsList = goodsList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Seller) {
            return this.id.equals(((Seller) obj).getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
