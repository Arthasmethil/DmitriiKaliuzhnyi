package com.epam.tc.hw2.utils;

public class StringEditorForLogs {

    public static String cutTimeOfLogString(String logStringWithTime) {
        return logStringWithTime.replaceFirst("^[\\d]{2}:[\\d]{2}:[\\d]{2} ", "");
    }
}
