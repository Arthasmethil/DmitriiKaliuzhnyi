package com.epam.tc.hw03.composite.component.common;

import com.epam.tc.hw03.composite.component.AbstractBaseComponent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenu extends AbstractBaseComponent {
    @FindBy(css = "#mCSB_1_container > ul > *")
    private List<WebElement> leftMenu;

    public LeftMenu(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getLeftItems() {
        return leftMenu;
    }

    public void clickOnItem(String itemText) {
        for (WebElement item : leftMenu) {
            if (item.getText().equals(itemText)) {
                item.click();
            }
        }
    }
}
