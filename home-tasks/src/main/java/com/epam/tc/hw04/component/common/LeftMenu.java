package com.epam.tc.hw04.component.common;

import com.epam.tc.hw04.component.AbstractBaseComponent;
import io.qameta.allure.Step;
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

    @Step("Click on header menu '{itemText}'")
    public void clickOnItem(final String itemText) {
        super.clickOnItem(getLeftMenu(), itemText);
    }

}
