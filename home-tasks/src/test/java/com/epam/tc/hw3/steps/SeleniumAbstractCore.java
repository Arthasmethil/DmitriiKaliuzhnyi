package com.epam.tc.hw3.steps;

import com.epam.tc.hw03.composite.property.PropertiesData;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public abstract class SeleniumAbstractCore {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected PropertiesData propertiesData;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        propertiesData = new PropertiesData();
        driver.get(propertiesData.getAddress());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
