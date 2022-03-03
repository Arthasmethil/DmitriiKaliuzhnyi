package com.epam.tc.hw5.steps;

import static com.epam.tc.hw05.component.common.HeaderMenu.HEAD_SERVICE;
import static com.epam.tc.hw05.component.ex2.ServiceDropdownMenu.HEAD_DIFFERENT_ELEMENTS;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        indexPage.headMenu().clickOnItem(HEAD_SERVICE);
        indexPage.dropdownServiceMenu().clickOnItem(HEAD_DIFFERENT_ELEMENTS);
    }

    @Step("Select checkboxes: Water, Wind")
    public void selectCheckboxes() {
        differentElementsPage.checkboxes().selectWaterCheckbox();
        differentElementsPage.checkboxes().selectWindCheckbox();
    }

    @Step("Select radio: Selen")
    public void selectRadio() {
        differentElementsPage.checkboxes().selectSelenRadio();
    }

    @Step("Select color: Yellow")
    public void selectColor() {
        differentElementsPage.checkboxes().selectYellowColors();
    }

    @Step("Perform Login")
    public void login(String name, String password) {
        indexPage.login().signIn(name, password);
    }

    @Step("Switch to the iframe")
    public void switchToFrame() {
        indexPage.switchToIframe();
    }

    @Step("Switch to original window back")
    public void switchToDefaultPage() {
        indexPage.switchToDefaultContent();
    }

}
