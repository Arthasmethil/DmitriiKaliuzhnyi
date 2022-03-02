package com.epam.tc.hw4.ex1;

import static com.epam.tc.hw04.component.common.HeaderMenu.HEAD_SERVICE;
import static com.epam.tc.hw04.component.ex2.ServiceDropdownMenu.HEAD_DIFFERENT_ELEMENTS;

import com.epam.tc.hw04.pages.DifferentElementsPage;
import com.epam.tc.hw04.pages.IndexPageForExTwo;
import com.epam.tc.hw04.support.Data;
import com.epam.tc.hw4.data.provider.DataProviderTest;
import com.epam.tc.hw4.steps.SeleniumAbstractCore;
import com.epam.tc.hw4.storynames.Tags;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Epic(Tags.SUCCESS_TESTS)
@Feature(Tags.ASSERTJ_TEST_FEATURE)
public class JenkinsExerciseAssertJTest extends SeleniumAbstractCore {


    @Test(description = "Hard asserts test, exercise 1 Jenkins",
          dataProvider = "testDataForJenkins",
          dataProviderClass = DataProviderTest.class)
    @Description("Another path to test by AssertJ")
    @Story(Tags.INTEGRATION_HARD_STORY)
    public void checkAndSearchElementsOnDifferentElementsPage(Data data) {

        // "1. Open test site by URL in setUp method"
        // "2. Assert Browser title"
        Assertions.assertThat(driver.getTitle()).isEqualTo(data.getTitle());

        // "3. User is logged"
        IndexPageForExTwo indexPageForExTwo = new IndexPageForExTwo(driver);
        indexPageForExTwo.login().signIn(data.getLogin(), data.getPassword());

        // "4. Name is displayed and equals to expected result"
        Assertions.assertThat(indexPageForExTwo.login().getSignedUserName())
                  .matches(WebElement::isDisplayed)
                  .extracting(WebElement::getText)
                  .isEqualTo(data.getDisplayedName());

        // "5. Open through the header menu Service -> Different Elements Page"
        indexPageForExTwo.headMenu().clickOnItem(HEAD_SERVICE);

        // "5.1 Different elements is selected"
        indexPageForExTwo.dropdownServiceMenu().clickOnItem(HEAD_DIFFERENT_ELEMENTS);

        // "6. Select checkboxes, 7. Select radio, 8. Select color"
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        differentElementsPage.checkboxes().selectWindWaterSelenYellow();

        // "9. Assert that for each checkbox there is an individual log row and value"
        Assertions.assertThat(differentElementsPage.readLogSection().getListOfLogs())
              .hasSize(data.getExpectedTextLogs().size())
              .containsExactlyElementsOf(data.getExpectedTextLogs());
    }
}
