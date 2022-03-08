package com.epam.tc.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw05.component.domain.User;
import com.epam.tc.hw5.cucumber.context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
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

    @Then("User table should contain following values:")
    public void assertActualUserListWithExpected(DataTable table) {
        List<User> expectedUserList = new ArrayList<>();
        List<Map<String, String>> rows = table.asMaps();
        for (Map<String, String> column : rows) {
            expectedUserList.add(new User(
                column.get("Number"),
                column.get("User"),
                column.get("Description")
            ));
        }
        assertThat(userTablePage.userTable().getUserList())
            .hasSize(expectedUserList.size())
            .containsExactlyElementsOf(expectedUserList);
    }


    @Then("{string} page should be opened")
    public void assertUserTableTitle(String userTableTitle) {
        WebDriver driver = TestContext.getInstance().getObject("driver", WebDriver.class);
        assertThat(driver.getTitle()).isEqualTo(userTableTitle);
    }

    @Then("droplist should contain values in column Type for user {string}")
    public void assertDropdownForUser(String username, DataTable table) {
        List<String> datatableList = table.asList();
        List<String> expectedValues = datatableList.subList(1, datatableList.size());
        List<String> actualValues = userTablePage.userTable().getUserDropdownValues(username);
        assertThat(actualValues)
            .hasSize(expectedValues.size())
            .containsExactlyElementsOf(expectedValues);
    }
}
