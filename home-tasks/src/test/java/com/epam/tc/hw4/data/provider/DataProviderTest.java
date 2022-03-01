package com.epam.tc.hw4.data.provider;

import static com.epam.tc.hw4.constants.ExpectedValuesConstants.EXPECTED_ICON_TEXTS;
import static com.epam.tc.hw4.constants.ExpectedValuesConstants.EXPECTED_TEXT_HEADER_MENU;
import static com.epam.tc.hw4.constants.ExpectedValuesConstants.EXPECTED_TEXT_LEFT_MENU;
import static com.epam.tc.hw4.constants.ExpectedValuesConstants.EXPECTED_TEXT_LOG_WITHOUT_TIME;
import static com.epam.tc.hw4.constants.ExpectedValuesConstants.EXPECTED_TITLE;

import com.epam.tc.hw04.support.PropertiesProvider;
import com.epam.tc.hw04.support.Data;
import org.testng.annotations.DataProvider;

public class DataProviderTest {

    @DataProvider(name = "testDataForJenkins")
    public static Object[][] testDataForJenkins() {
        PropertiesProvider properties = new PropertiesProvider();
        return new Object[][] {
            {
                new Data(EXPECTED_TITLE, properties.getProperty("name"), properties.getProperty("password"),
                    properties.getProperty("displayed.name"), EXPECTED_TEXT_HEADER_MENU, EXPECTED_TEXT_LEFT_MENU,
                EXPECTED_ICON_TEXTS, EXPECTED_TEXT_LOG_WITHOUT_TIME)
            }
        };
    }
}
