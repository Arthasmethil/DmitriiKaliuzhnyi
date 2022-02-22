package com.epam.tc.hw03.composite.component.common;

import com.epam.tc.hw03.composite.component.AbstractBaseComponent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractBaseComponent {
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> headerMenu;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getMenuItems() {
        return headerMenu;
    }

    public void clickOnItem(String itemText) {
        for (WebElement item : headerMenu) {
            if (item.getText().equals(itemText)) {
                item.click();
            }
        }
    }
}
