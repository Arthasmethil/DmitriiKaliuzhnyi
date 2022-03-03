package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Assert Browser title")
    public void assertBrowserTitle(String expectedTitle) {
        assertThat(driver.getTitle()).isEqualTo(expectedTitle);
    }

    @Step("Assert username is displayed and equals to expected result")
    public void assertSignedUsername(String expectedUsername) {
        assertThat(indexPage.login().getSignedUserName())
            .matches(WebElement::isDisplayed)
            .extracting(WebElement::getText)
            .isEqualTo(expectedUsername);
    }

    @Step("Assert that for each checkbox there is an individual log row and value")
    public void assertLogSectionWithLogsDisplayed(List<String> expectedLogsList) {
        assertThat(differentElementsPage.readLogSection().getListOfLogs())
            .hasSize(expectedLogsList.size())
            .containsExactlyElementsOf(expectedLogsList);
    }

}
