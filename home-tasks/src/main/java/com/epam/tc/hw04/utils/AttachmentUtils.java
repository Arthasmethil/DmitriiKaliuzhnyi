package com.epam.tc.hw04.utils;

import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AttachmentUtils {

    @Attachment(type = "image/png", value = "Screenshot: {failureScreenName}")
    public byte[] makeScreenshot(String failureScreenName, byte[] source) {
        return source;
    }
}
