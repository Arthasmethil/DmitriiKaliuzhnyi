package com.epam.tc.jdi;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public interface JdiTestInit {

    @BeforeClass(alwaysRun = true)
    static void setUp() {
        logger.setLogLevel(STEP);
        initElements(JdiTestSite.class);
    }

    @AfterClass(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }

}

