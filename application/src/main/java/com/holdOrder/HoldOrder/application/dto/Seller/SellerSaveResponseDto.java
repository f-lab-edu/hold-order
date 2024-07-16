package com.holdOrder.HoldOrder.application.dto.Seller;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SellerSaveResponseDto {
    private String name;
    private String creator;
    private LocalDateTime createdAt;
}
