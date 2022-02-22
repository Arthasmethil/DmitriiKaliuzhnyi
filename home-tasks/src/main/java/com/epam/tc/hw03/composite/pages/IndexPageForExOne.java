package com.epam.tc.hw03.composite.pages;

import com.epam.tc.hw03.composite.component.ex1.Icons;
import com.epam.tc.hw03.composite.component.ex1.IframeWindowComponent;
import org.openqa.selenium.WebDriver;

public class IndexPageForExOne extends AbstractIndexPage {

    protected Icons icons;
    protected IframeWindowComponent iframe;

    public IndexPageForExOne(WebDriver driver) {
        super(driver);
        icons = new Icons(driver);
        iframe = new IframeWindowComponent(driver);
    }

    public IframeWindowComponent iframe() {
        return this.iframe;
    }

    public Icons icons() {
        return this.icons;
    }

    public void switchToIframe() {
        driver.switchTo().frame(IframeWindowComponent.FRAME_ID_NAME);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
