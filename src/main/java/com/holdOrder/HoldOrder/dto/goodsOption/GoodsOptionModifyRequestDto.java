package com.holdOrder.HoldOrder.dto.goodsOption;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsOptionModifyRequestDto {
    @NotNull
    @Positive
    @Max(value = Long.MAX_VALUE)
    private Long id;
    @NotNull
    @Size(min = 2, max = 100, message = "상품 옵션 명은 최소 두 글자, 최대 100 글자 까지 가능합니다.")
    private String name;
    @PositiveOrZero
    @NotNull
    private Integer optionPrice;
    private Integer sort;


}
