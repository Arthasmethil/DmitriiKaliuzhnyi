package com.epam.tc.hw06.utils;

public class StringEditorForLogs {
    public static String cutTimeOfLogString(String logStringWithTime) {
        return logStringWithTime.replaceFirst("^[\\d]{2}:[\\d]{2}:[\\d]{2} ", "");
    }
}
