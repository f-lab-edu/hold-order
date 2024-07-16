package com.holdOrder.HoldOrder.core.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GoodsDeletedState {
    Y("삭제"),
    N("사용가능");

    private String description;
}
