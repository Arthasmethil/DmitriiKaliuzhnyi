package com.epam.tc.hw03.composite.fluent.component;

import com.epam.tc.hw03.composite.component.AbstractBaseComponent;
import com.epam.tc.hw03.composite.fluent.page.DifferentElementsPageFluent;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class HeaderMenu extends AbstractBaseComponent {
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> menuItems;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Different elements')]")
    private WebElement differentElementsOfService;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> menuItems() {
        return menuItems;
    }

    public HeaderMenu clickOnItem(String itemText) {
        super.clickOnItem(getMenuItems(), itemText);
        return this;
    }

    public DifferentElementsPageFluent navigateToDifferentElementsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(differentElementsOfService)).click();
        return new DifferentElementsPageFluent(driver);
    }
}
