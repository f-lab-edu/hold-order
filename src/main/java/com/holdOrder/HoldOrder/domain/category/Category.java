package com.holdOrder.HoldOrder.domain.category;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Builder
public class Category {
    private String categoryId;
    private String categoryNm;
    private Timestamp regiDt;
    private Timestamp updaDt;

}
