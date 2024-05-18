package com.holdOrder.HoldOrder.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
public class User {

    private String userId;
    private String nickName;
    private String name;
    private UserRoleType role;
    private Timestamp regiDt;
    private Timestamp updaDt;

    @Builder
    public User(String userId, String nickName, String name, UserRoleType role, Timestamp regiDt, Timestamp updaDt) {
        this.userId = userId;
        this.nickName = nickName;
        this.name = name;
        this.role = role;
        this.regiDt = regiDt;
        this.updaDt = updaDt;
    }
}
