package com.epam.tc.hw05.pages;

import com.epam.tc.hw05.component.ex1.Icons;
import com.epam.tc.hw05.component.ex1.IframeWindowComponent;
import com.epam.tc.hw05.component.ex2.ServiceDropdownMenu;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends AbstractIndexPage {
    protected Icons icons;
    protected IframeWindowComponent iframeWindowComponent;
    protected ServiceDropdownMenu dropdownHeaderMenu;

    @FindBy(id = "frame")
    @Getter
    private List<WebElement> iframe;

    public IndexPage(WebDriver driver) {
        super(driver);
        icons = new Icons(driver);
        iframeWindowComponent = new IframeWindowComponent(driver);
        dropdownHeaderMenu = new ServiceDropdownMenu(driver);
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

    public ServiceDropdownMenu dropdownServiceMenu() {
        return this.dropdownHeaderMenu;
    }
}
