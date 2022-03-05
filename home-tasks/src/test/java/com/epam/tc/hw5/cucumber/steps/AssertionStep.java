package com.epam.tc.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

public class AssertionStep extends AbstractStep {

    @Then("Assert username is displayed and equals to expected result")
    public void assertSignedUsername() {
        assertThat(indexPage.login().getSignedUserName())
            .matches(WebElement::isDisplayed)
            .extracting(WebElement::getText)
            .isEqualTo(data.getDisplayedName());
    }

    @Then("For each checkbox, radio, color there is an individual log row and "
        + "value is corresponded to the status of each of it")
    public void assertLogSectionWithLogsDisplayed() {
        assertThat(differentElementsPage.readLogSection().getListOfLogs())
            .hasSize(data.getExpectedTextLogs().size())
            .containsExactlyElementsOf(data.getExpectedTextLogs());
    }

    @Then("{int} log row has 'Vip: condition changed to true' text in log section")
    public void assertLogUserSection(int logRows) {
        assertThat(userTablePage.userTable().logSection())
            .hasSize(logRows)
            .containsExactlyElementsOf(data.getExpectedUserLogSection());
    }


    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertDropdownsExists(int expectedValue) {
        assertThat(userTablePage.userTable().getUserDropdown())
            .hasSize(expectedValue)
            .allMatch(WebElement::isDisplayed);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void assertUserDropdownsExists(int expectedValue) {
        assertThat(userTablePage.userTable().getUsernames())
            .hasSize(expectedValue)
            .allMatch(WebElement::isDisplayed);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void assertUsernamesExists(int expectedValue) {
        assertThat(userTablePage.userTable().getUserDescription())
            .hasSize(expectedValue)
            .allMatch(WebElement::isDisplayed);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void assertUserDescriptionExists(int expectedValue) {
        assertThat(userTablePage.userTable().getCheckboxes())
            .hasSize(expectedValue)
            .allMatch(WebElement::isDisplayed);
    }

}
