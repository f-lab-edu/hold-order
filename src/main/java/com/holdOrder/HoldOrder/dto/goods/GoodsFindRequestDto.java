package com.holdOrder.HoldOrder.dto.goods;

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
    @Size(min = 2, max = 100, message = "상품 명은 최소 두 글자, 최대 100 글자 까지 가능합니다.")
    private String name;

    @Positive
    @Max(value = Long.MAX_VALUE)
    private Integer goodsPrice;

    @PastOrPresent(message = "과거 또는 현재 시간만 설정이 가능합니다.")
    private LocalDateTime createdAt;

    @PastOrPresent(message = "과거 또는 현재 시간만 설정이 가능합니다.")
    private LocalDateTime modifiedAt;
}
