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

    @Step("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertHeaderItemsExists(List<String> expectedHeaderItems) {
        assertThat(indexPage.headMenu().getMenuItems())
            .hasSize(expectedHeaderItems.size())
            .allMatch(WebElement::isDisplayed, "WebElement should be display")
            .extracting(WebElement::getText)
            .containsExactlyElementsOf(expectedHeaderItems);
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void assertIconsDisplayed(List<String> expectedIconList) {
        assertThat(indexPage.icons().getBenefitIcons())
            .hasSize(expectedIconList.size())
            .allMatch(WebElement::isDisplayed, "WebElement should be display");
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertTextUnderIconsDisplayed(List<String> expectedIconTextList) {
        assertThat(indexPage.icons().getBenefitText())
            .hasSize(expectedIconTextList.size())
            .allMatch(WebElement::isDisplayed, "WebElement should be display")
            .extracting(WebElement::getText)
            .containsExactlyElementsOf(expectedIconTextList);
    }

    @Step("Assert that there is the iframe with 'Frame Button' exist")
    public void assertFrameExists() {
        assertThat(indexPage.getIframe())
            .hasAtLeastOneElementOfType(WebElement.class)
            .allMatch(WebElement::isDisplayed);
    }

    @Step("Switch to the iframe and check that there is “Frame Button” in the iframe")
    public void assertThatButtonInFrameExist() {
        assertThat(indexPage.iframeWindow().getIframeButton())
              .hasAtLeastOneElementOfType(WebElement.class)
              .allMatch(WebElement::isDisplayed);
    }

    @Step("Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void assertLeftMenuAreDisplayed(List<String> expectedLeftMenuList) {
        assertThat(indexPage.leftMenu().getLeftMenu())
            .hasSize(expectedLeftMenuList.size())
            .allMatch(WebElement::isDisplayed, "WebElement should be display")
            .extracting(WebElement::getText)
            .containsExactlyElementsOf(expectedLeftMenuList);
    }

    @Step("Assert that for each checkbox there is an individual log row and value")
    public void assertLogSectionWithLogsDisplayed(List<String> expectedLogsList) {
        assertThat(differentElementsPage.readLogSection().getListOfLogs())
            .hasSize(expectedLogsList.size())
            .containsExactlyElementsOf(expectedLogsList);
    }

}
