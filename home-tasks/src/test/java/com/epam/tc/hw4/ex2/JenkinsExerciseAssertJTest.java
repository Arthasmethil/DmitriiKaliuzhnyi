package com.epam.tc.hw4.ex2;

import static com.epam.tc.hw04.component.common.HeaderMenu.HEAD_SERVICE;
import static com.epam.tc.hw04.component.ex2.ServiceDropdownMenu.HEAD_DIFFERENT_ELEMENTS;
import static com.epam.tc.hw4.constants.ExpectedValuesConstants.EXPECTED_TEXT_LOG_WITHOUT_TIME;
import static com.epam.tc.hw4.constants.ExpectedValuesConstants.EXPECTED_TITLE;
import static io.qameta.allure.Allure.step;

import com.epam.tc.hw04.pages.DifferentElementsPage;
import com.epam.tc.hw04.pages.IndexPageForExTwo;
import com.epam.tc.hw4.steps.SeleniumAbstractCore;
import com.epam.tc.hw4.storynames.Tags;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Feature(Tags.ASSERTJ_TEST_FEATURE)
public class JenkinsExerciseAssertJTest extends SeleniumAbstractCore {

    @Test(description = "Hard asserts test, exercise 2")
    @Description("Another path to test by AssertJ")
    @Story(Tags.INTEGRATION_HARD_STORY)
    public void checkAndSearchElementsOnDifferentElementsPage() {

        step("1. Open test site by URL in setUp method");
        step("2. Assert Browser title");
        Assertions.assertThat(driver.getTitle()).isEqualTo(EXPECTED_TITLE);

        step("3. User is logged");
        IndexPageForExTwo indexPageForExTwo = new IndexPageForExTwo(driver);
        indexPageForExTwo.login().signIn(properties.getProperty("name"), properties.getProperty("password"));

        step("4. Name is displayed and equals to expected result");
        Assertions.assertThat(indexPageForExTwo.login().getSignedUserName())
                  .matches(WebElement::isDisplayed)
                  .extracting(WebElement::getText)
                  .isEqualTo(properties.getProperty("displayed.name"));

        step("5. Open through the header menu Service -> Different Elements Page");
        indexPageForExTwo.headMenu().clickOnItem(HEAD_SERVICE);

        step("5.1 Different elements is selected");
        indexPageForExTwo.dropdownServiceMenu().clickOnItem(HEAD_DIFFERENT_ELEMENTS);

        step("6. Select checkboxes, 7. Select radio, 8. Select color");
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        differentElementsPage.checkboxes().selectWindWaterSelenYellow();

        step("9. Assert that for each checkbox there is an individual log row and value");
        Assertions.assertThat(differentElementsPage.readLogSection().getListOfLogs())
              .hasSize(EXPECTED_TEXT_LOG_WITHOUT_TIME.size())
              .containsExactlyElementsOf(EXPECTED_TEXT_LOG_WITHOUT_TIME);
    }
}
