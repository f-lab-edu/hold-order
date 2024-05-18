package com.holdOrder.HoldOrder.domain.category;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Entity
public class Category {
    @Id
    private String categoryId;
    private String categoryNm;
    private Timestamp regiDt;
    private Timestamp updaDt;

    @Builder
    public Category(String categoryId, String categoryNm, Timestamp regiDt, Timestamp updaDt) {
        this.categoryId = categoryId;
        this.categoryNm = categoryNm;
        this.regiDt = regiDt;
        this.updaDt = updaDt;
    }
}
