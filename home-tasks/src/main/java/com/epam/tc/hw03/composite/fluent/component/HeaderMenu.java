package com.epam.tc.hw03.composite.fluent.component;

import com.epam.tc.hw03.composite.component.AbstractBaseComponent;
import com.epam.tc.hw03.composite.fluent.page.DifferentElementsPageFluent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderMenu extends AbstractBaseComponent {
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> headerMenu;

    @FindBy(xpath = "//a[contains(text(),'Different elements')]")
    private WebElement differentElementsOfService;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getMenuItems() {
        return headerMenu;
    }

    public HeaderMenu clickOnItem(String itemText) {
        for (WebElement item : headerMenu) {
            if (item.getText().equals(itemText)) {
                item.click();
            }
        }
        return this;
    }

    public DifferentElementsPageFluent navigateToDifferentElementsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(differentElementsOfService)).click();
        return new DifferentElementsPageFluent(driver);
    }
}
