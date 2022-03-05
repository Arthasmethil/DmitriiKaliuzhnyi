package com.epam.tc.hw05.component.domain;

import com.epam.tc.hw05.component.AbstractBaseComponent;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ServiceDropdownMenu extends AbstractBaseComponent {

    public static final String HEAD_DIFFERENT_ELEMENTS = "DIFFERENT ELEMENTS";
    public static final String HEAD_USER_TABLE = "USER TABLE";

    @FindBy(css = ".dropdown-menu > li")
    private List<WebElement> dropdownServiceMenu;

    public ServiceDropdownMenu(WebDriver driver) {
        super(driver);
    }

    public void clickOnItem(String itemText) {
        clickOnItem(dropdownServiceMenu, itemText);
    }

}
