package com.epam.tc.hw4.constants;

import java.util.List;

public class ExpectedValuesConstants {

    // Expectations for point 2 GENERAL
    public static final String EXPECTED_TITLE = "Home Page";

    // Expectations for point 5 exercise 1
    public static final List<String> EXPECTED_TEXT_HEADER_MENU = List.of(
        "HOME", "CONTACT FORM",
        "SERVICE", "METALS & COLORS");

    // Expectations for point 7
    public static final List<String> EXPECTED_ICON_TEXTS = List.of(
        "To include good practices\nand ideas from successful\nEPAM project",
        "To be flexible and\ncustomizable",
        "To be multiplatform",
        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    // Expectations for point 9 exercise 2
    public static final List<String> EXPECTED_TEXT_LOG_WITHOUT_TIME = List.of(
        "Colors: value changed to Yellow",
        "metal: value changed to Selen",
        "Wind: condition changed to true",
        "Water: condition changed to true");

    // Expectations for point 11 exercise 1
    public static final List<String> EXPECTED_TEXT_LEFT_MENU = List.of(
        "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
}
