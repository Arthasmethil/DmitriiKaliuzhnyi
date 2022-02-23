package com.epam.tc.hw03.composite.fluent.component;

import com.epam.tc.hw03.composite.component.AbstractBaseComponent;
import com.epam.tc.hw03.composite.fluent.page.DifferentElementsPageFluent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Checkbox extends AbstractBaseComponent {

    @FindBy(className = "main-content-hg")
    private WebElement containerOfCheckboxes;

    @FindBy(xpath = "//label[@class='label-checkbox' and normalize-space(string())='Water']")
    private WebElement waterCheckboxElement;

    @FindBy(xpath = "//label[@class='label-checkbox' and normalize-space(string())='Wind']")
    private WebElement windCheckboxElement;

    @FindBy(xpath = "//label[@class='label-radio' and normalize-space(string())='Selen']")
    private WebElement selenRadioElement;

    @FindBy(xpath = "//option[contains(text(),'Yellow')]")
    private WebElement yellowColorElement;

    public Checkbox(WebDriver driver) {
        super(driver);
    }

    public DifferentElementsPageFluent visibilityOfCheckboxes() {
        wait.until(ExpectedConditions.visibilityOf(containerOfCheckboxes));
        return new DifferentElementsPageFluent(driver);
    }

    public Checkbox selectWaterCheckbox() {
        waterCheckboxElement.click();
        return this;
    }

    public Checkbox selectWindCheckbox() {
        windCheckboxElement.click();
        return this;
    }

    public Checkbox selectSelenRadio() {
        selenRadioElement.click();
        return this;
    }

    public Checkbox selectYellowColors() {
        yellowColorElement.click();
        return this;
    }

    public DifferentElementsPageFluent goToDifferentElementsPageFluent() {
        return new DifferentElementsPageFluent(driver);
    }
}
