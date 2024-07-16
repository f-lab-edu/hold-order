package com.holdOrder.HoldOrder.core.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GoodsUsedState {
    Y("활성화"),
    N("비활성화");

    private String description;
}
