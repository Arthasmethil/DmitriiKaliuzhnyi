package com.epam.tc.hw04.component;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void clickOnItem(final List<WebElement> list, final String itemText) {
        for (WebElement item : list) {
            if (item.getText().equals(itemText)) {
                item.click();
            }
        }
    }
}
