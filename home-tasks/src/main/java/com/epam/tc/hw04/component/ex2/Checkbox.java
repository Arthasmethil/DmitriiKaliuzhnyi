package com.epam.tc.hw04.component.ex2;

import com.epam.tc.hw04.component.AbstractBaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Checkbox extends AbstractBaseComponent {

    @FindBy(className = "main-content-hg")
    private WebElement mainContentToSelect;

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

    public void ensureVisibilityOfCheckboxesRadioColors() {
        wait.until(ExpectedConditions.visibilityOf(mainContentToSelect));
    }

    public void selectWaterCheckbox() {
        waterCheckboxElement.click();
    }

    public void selectWindCheckbox() {
        windCheckboxElement.click();
    }

    public void selectSelenRadio() {
        selenRadioElement.click();
    }

    public void selectYellowColors() {
        yellowColorElement.click();
    }

    public void selectWindWaterSelenYellow() {
        ensureVisibilityOfCheckboxesRadioColors();
        selectWaterCheckbox();
        selectWindCheckbox();
        selectSelenRadio();
        selectYellowColors();
    }
}
