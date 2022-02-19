package com.epam.tc.hw2.steps;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringEditorForLogs {

    public static String cutTimeOfLogString(String logStringWithTime) {
        Matcher matcher = Pattern.compile("[a-zA-Z]+:.*").matcher(logStringWithTime);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            stringBuilder.append(matcher.group());
        }
        return stringBuilder.toString();
    }
}
