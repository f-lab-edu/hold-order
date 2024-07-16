package com.holdOrder.HoldOrder.application.dto.goods;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
public class GoodsSearchRequestDto {
    private String nameLike; // 이름 LIKE
    private String sellerNameLike; // 판매자 LIKE
    private Integer goodsPriceFrom; // 상품 가격 범위 시작
    private Integer goodsPriceTo; // 상품 가격 범위 끝
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAtFrom; // 생성일 범위 시작
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAtTo; // 생성일 범위 끝
    private Integer pageIndex;
    private Integer pageSize;

}
