package com.holdOrder.HoldOrder.core.util;

import java.time.LocalDateTime;

public class Utility {

    public static boolean isEmpty(Integer integer) {
        if (integer == null || integer == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return true;
        }
        return false;
    }
}
