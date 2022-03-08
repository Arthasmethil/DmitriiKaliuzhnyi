package com.epam.tc.hw6.steps;

import com.epam.tc.hw06.service.webdriver.WebDriverProvider;
import com.epam.tc.hw06.support.PropertiesProvider;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class SeleniumAbstractCore {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected PropertiesProvider properties;

    @BeforeMethod
    @Step("initialization and config WebDriver")
    public void setUp(ITestContext context) {
        driver = WebDriverProvider.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        properties = new PropertiesProvider();
        driver.get(properties.getProperty("address"));
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    @Step("quit drive to clean memory")
    public void tearDown() {
        WebDriverProvider.closeDriver();
    }
}
