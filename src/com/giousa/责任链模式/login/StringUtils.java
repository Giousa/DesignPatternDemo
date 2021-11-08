package com.giousa.责任链模式.login;

import java.util.Objects;

public class StringUtils {

    public static boolean isEmpty(String str) {
        return Objects.equals(str, null) || Objects.equals(str, "");
    }
}
