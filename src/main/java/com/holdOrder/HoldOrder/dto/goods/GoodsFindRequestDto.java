package com.holdOrder.HoldOrder.dto.goods;

import com.holdOrder.HoldOrder.domain.goods.Goods;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GoodsFindRequestDto {
    @NotNull
    @Positive
    @Max(value = Long.MAX_VALUE)
    private Long id;
    @NotNull
    @Size(min = 2, max = 100, message = "상품 명은 최소 두 글자, 최대 100 글자 까지 가능합니다.")
    private String name;

    @NotNull
    @Positive(message = "양수만 가능합니다.")
    @Max(value = Long.MAX_VALUE)
    private Integer goodsPrice;

    @NotNull
    @PastOrPresent(message = "과거 또는 현재 시간만 설정이 가능합니다.")
    private LocalDateTime createdAt;

    @NotNull
    @PastOrPresent(message = "과거 또는 현재 시간만 설정이 가능합니다.")
    private LocalDateTime modifiedAt;

    public Goods toEntity() {
        Goods goods = Goods.builder()
                .name(this.name)
                .goodsPrice(this.goodsPrice)
                .build();
        goods.setCreatedAt(this.createdAt);
        goods.setModifiedAt(this.modifiedAt);
        return goods;
    }
}
