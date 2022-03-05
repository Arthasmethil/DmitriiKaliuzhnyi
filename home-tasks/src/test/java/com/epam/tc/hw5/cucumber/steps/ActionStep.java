package com.epam.tc.hw5.cucumber.steps;

import static com.epam.tc.hw05.component.common.HeaderMenu.HEAD_SERVICE;
import static com.epam.tc.hw05.component.domain.ServiceDropdownMenu.HEAD_DIFFERENT_ELEMENTS;
import static com.epam.tc.hw05.component.domain.ServiceDropdownMenu.HEAD_USER_TABLE;

import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {

    @When("I open JDI GitHub site")
    public void openIndexPage() {
        indexPage.open();
    }

    @When("I click on 'Service' button in Header")
    public void openServiceHeaderDropdown() {
        indexPage.headMenu().clickOnItem(HEAD_SERVICE);
    }

    @When("I click on 'Different Elements Page' button in Service dropdown")
    public void openDifferentElementsPage() {
        indexPage.dropdownServiceMenu().clickOnItem(HEAD_DIFFERENT_ELEMENTS);
    }

    @When("I click on 'User Table Page' button in Service dropdown")
    public void openUserTablePage() {
        indexPage.dropdownServiceMenu().clickOnItem(HEAD_USER_TABLE);
    }

    @When("I select 'Water' and 'Wind' checkbox")
    public void selectCheckboxes() {
        differentElementsPage.checkboxes().selectWaterCheckbox();
        differentElementsPage.checkboxes().selectWindCheckbox();
    }

    @When("I select 'Selen' radio")
    public void selectRadio() {
        differentElementsPage.checkboxes().selectSelenRadio();
    }

    @When("I select 'Yellow' color in dropdown")
    public void selectColor() {
        differentElementsPage.checkboxes().selectYellowColors();
    }

    @When("I login as user 'Roman Iovlev'")
    public void login() {
        indexPage.login().signIn(data.getLogin(), data.getPassword());
    }

    //@When("I select 'vip' checkbox for 'Sergey Ivan'")
    //public void selectIvanCheckbox() {
    //userTablePage.userList().clickOnIvanCheckbox();
    //}

}
