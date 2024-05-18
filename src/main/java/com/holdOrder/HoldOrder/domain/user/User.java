package com.holdOrder.HoldOrder.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Builder
public class User {

    private String userId;
    private String nickName;
    private String name;
    private UserRoleType role;
    private Timestamp regiDt;
    private Timestamp updaDt;

}
