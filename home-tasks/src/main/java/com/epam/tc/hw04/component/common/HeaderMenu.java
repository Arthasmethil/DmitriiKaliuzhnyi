package com.epam.tc.hw04.component.common;

import com.epam.tc.hw04.component.AbstractBaseComponent;
import io.qameta.allure.Step;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HeaderMenu extends AbstractBaseComponent {
    public static final String HEAD_SERVICE = "SERVICE";

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> menuItems;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Click on header menu '{itemText}'")
    public void clickOnItem(final String itemText) {
        clickOnItem(menuItems, itemText);
    }

}
