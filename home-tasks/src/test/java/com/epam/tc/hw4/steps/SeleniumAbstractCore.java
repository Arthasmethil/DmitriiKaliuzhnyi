package com.epam.tc.hw4.steps;

import static io.qameta.allure.Allure.step;

import com.epam.tc.hw04.support.PropertiesProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
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
    protected PropertiesProvider properties;

    @BeforeSuite
    @Step("setup WebDriverManager chrome")
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    @Step("initialization and config WebDriver with properties")
    public void setUp() {
        step("Setup Chrome options");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        step("Initializing driver and waits");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        step("Go to site address");
        properties = new PropertiesProvider();
        driver.get(properties.getProperty("address"));
    }

    @AfterClass
    @Step("quit drive to clean a memory")
    public void tearDown() {
        driver.quit();
    }
}
