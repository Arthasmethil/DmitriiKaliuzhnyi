package com.epam.tc.hw5.steps;

import com.epam.tc.hw05.pages.DifferentElementsPage;
import com.epam.tc.hw05.pages.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractStep {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected IndexPage indexPage;
    protected DifferentElementsPage differentElementsPage;

    public AbstractStep(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.indexPage =  new IndexPage(driver);
        this.differentElementsPage =  new DifferentElementsPage(driver);
    }
}
