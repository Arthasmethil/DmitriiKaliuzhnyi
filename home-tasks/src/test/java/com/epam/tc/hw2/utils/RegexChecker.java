package com.epam.tc.hw2.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChecker {

    public static String cutTimeOfLogString(String logStringWithTime) {
        Matcher matcher = Pattern.compile("[a-zA-Z]+:.*").matcher(logStringWithTime);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            stringBuilder.append(matcher.group());
        }
        return stringBuilder.toString();
    }
}
