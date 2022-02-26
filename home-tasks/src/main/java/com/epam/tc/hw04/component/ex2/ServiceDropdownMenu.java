package com.epam.tc.hw04.component.ex2;

import com.epam.tc.hw04.component.AbstractBaseComponent;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ServiceDropdownMenu extends AbstractBaseComponent {

    public static final String HEAD_DIFFERENT_ELEMENTS = "DIFFERENT ELEMENTS";

    @FindBy(css = ".dropdown-menu > li")
    private List<WebElement> dropdownServiceMenu;

    public ServiceDropdownMenu(WebDriver driver) {
        super(driver);
    }

    public void clickOnItem(String itemText) {
        try {
            super.clickOnItem(getDropdownServiceMenu(), itemText);
        } catch (StaleElementReferenceException e) {
            super.clickOnItem(getDropdownServiceMenu(), itemText);
        }
    }

}
