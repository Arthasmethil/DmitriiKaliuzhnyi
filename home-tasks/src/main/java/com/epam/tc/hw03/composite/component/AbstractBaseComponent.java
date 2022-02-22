package com.epam.tc.hw03.composite.component;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractBaseComponent {
    protected static final int WAIT_FOR_ELEMENTS_SECONDS = 15;
    protected WebDriver driver;
    protected WebDriverWait wait;


    protected AbstractBaseComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENTS_SECONDS));
        PageFactory.initElements(this.driver, this);
    }

}
