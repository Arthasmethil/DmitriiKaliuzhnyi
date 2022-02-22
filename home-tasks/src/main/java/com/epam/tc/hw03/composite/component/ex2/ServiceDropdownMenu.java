package com.epam.tc.hw03.composite.component.ex2;

import com.epam.tc.hw03.composite.component.AbstractBaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ServiceDropdownMenu extends AbstractBaseComponent {
    @FindBy(xpath = "//a[contains(text(),'Different elements')]")
    private WebElement differentElementsOfService;

    public ServiceDropdownMenu(WebDriver driver) {
        super(driver);
    }

    public void navigateToDifferentElementsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(differentElementsOfService)).click();
    }
}
