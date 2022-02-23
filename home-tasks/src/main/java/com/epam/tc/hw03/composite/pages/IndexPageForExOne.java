package com.epam.tc.hw03.composite.pages;

import com.epam.tc.hw03.composite.component.ex1.Icons;
import com.epam.tc.hw03.composite.component.ex1.IframeWindowComponent;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPageForExOne extends AbstractIndexPage {
    protected Icons icons;
    protected IframeWindowComponent iframeWindowComponent;

    @FindBy(id = "frame")
    @Getter
    private List<WebElement> iframe;

    public IndexPageForExOne(WebDriver driver) {
        super(driver);
        icons = new Icons(driver);
        iframeWindowComponent = new IframeWindowComponent(driver);
    }

    public IframeWindowComponent iframeWindow() {
        return this.iframeWindowComponent;
    }

    public Icons icons() {
        return this.icons;
    }

    public void switchToIframe() {
        driver.switchTo().frame(iframe.get(0));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
