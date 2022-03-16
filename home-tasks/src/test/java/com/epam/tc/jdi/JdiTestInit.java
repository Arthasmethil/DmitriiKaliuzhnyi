package com.epam.tc.jdi;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.tc.jdi.JdiTestSite.homePage;
import static com.epam.tc.jdi.entities.DefaultUser.DEFAULT_USER;
import static com.epam.tc.jdi.pages.HomePage.loginForm;
import static com.epam.tc.jdi.pages.HomePage.userIcon;

import com.epam.tc.jdi.pages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

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

    @BeforeMethod
    static  void openSiteAndLogin() {
        homePage.open();
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
    }

    @AfterMethod
    static  void logout() {
        HomePage.logout();
    }
}

