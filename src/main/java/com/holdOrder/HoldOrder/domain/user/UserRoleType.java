package com.holdOrder.HoldOrder.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRoleType {
    SELLER("판매자"), BUYER("구매자");

    private final String value;
}
