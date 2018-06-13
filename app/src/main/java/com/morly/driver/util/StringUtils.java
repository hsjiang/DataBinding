package com.morly.driver.util;

/**
 * Created by riven_chris on 2017/3/29.
 */

public class StringUtils {

    public static boolean isPhoneNumber(String str) {
        String regExp = "^[1]([3|7|5|8]{1}\\d{1})\\d{8}$";
        return str.matches(regExp);
    }
}
