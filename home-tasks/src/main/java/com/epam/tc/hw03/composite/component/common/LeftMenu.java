package com.epam.tc.hw03.composite.component.common;

import com.epam.tc.hw03.composite.component.AbstractBaseComponent;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LeftMenu extends AbstractBaseComponent {
    @FindBy(css = "#mCSB_1_container > ul > *")
    private List<WebElement> leftMenu;

    public LeftMenu(WebDriver driver) {
        super(driver);
    }

    public void clickOnItem(final String itemText) {
        super.clickOnItem(getLeftMenu(), itemText);
    }

}
