package com.epam.tc.hw5.constants;

import java.util.List;

public class ExpectedValuesConstants {

    public static final String EXPECTED_TITLE = "Home Page";

    public static final List<String> EXPECTED_TEXT_HEADER_MENU = List.of(
        "HOME", "CONTACT FORM",
        "SERVICE", "METALS & COLORS");

    public static final List<String> EXPECTED_ICON_TEXTS = List.of(
        "To include good practices\nand ideas from successful\nEPAM project",
        "To be flexible and\ncustomizable",
        "To be multiplatform",
        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    public static final List<String> EXPECTED_TEXT_LOG_WITHOUT_TIME = List.of(
        "Colors: value changed to Yellow",
        "metal: value changed to Selen",
        "Wind: condition changed to true",
        "Water: condition changed to true");

    public static final List<String> EXPECTED_TEXT_LEFT_MENU = List.of(
        "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

    public static final List<String> EXPECTED_USER_LOG = List.of("Vip: condition changed to true");
}
