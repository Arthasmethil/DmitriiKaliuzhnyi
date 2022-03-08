package com.epam.tc.hw5.constants;

import java.util.List;

public class ExpectedValuesConstants {

    public static final String EXPECTED_TITLE = "Home Page";

    public static final List<String> EXPECTED_TEXT_LOG_WITHOUT_TIME = List.of(
        "Colors: value changed to Yellow",
        "metal: value changed to Selen",
        "Wind: condition changed to true",
        "Water: condition changed to true");

    public static final List<String> EXPECTED_USER_LOG = List.of("Vip: condition changed to true");
}
