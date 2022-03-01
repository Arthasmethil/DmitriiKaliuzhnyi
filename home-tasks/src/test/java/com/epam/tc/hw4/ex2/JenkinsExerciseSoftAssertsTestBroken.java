package com.epam.tc.hw4.ex2;

import static io.qameta.allure.Allure.step;

import com.epam.tc.hw04.pages.IndexPageForExOne;
import com.epam.tc.hw4.constants.Data;
import com.epam.tc.hw4.constants.DataProviderTest;
import com.epam.tc.hw4.steps.SeleniumAbstractCore;
import com.epam.tc.hw4.storynames.Tags;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Epic(Tags.FAILED_TESTS)
@Feature(Tags.SOFT_ASSERT_TEST_FEATURE)
public class JenkinsExerciseSoftAssertsTestBroken extends SeleniumAbstractCore {

    @Story(Tags.INTEGRATION_SOFT_STORY)
    @Test(description = "Soft asserts test, exercise 1",
          dataProvider = "testDataForJenkins",
          dataProviderClass = DataProviderTest.class)
    @Description("Soft asserts with steps annotations, one of the way to test step by step")
    public void checkAndSearchElementsOnPageWithSoftAsserts(Data data) {
        SoftAssertions softly = new SoftAssertions();
        step("1. Open test site by URL in setUp method");

        step("2. Assert Browser title");
        softly.assertThat(driver.getTitle()).isEqualTo(data.getTitle());

        step("3. User is logged");
        IndexPageForExOne indexPageForExOne = new IndexPageForExOne(driver);
        indexPageForExOne.login().signIn(data.getLogin(), data.getPassword());

        step("4. Name is displayed and equals to expected result");
        softly.assertThat(indexPageForExOne.login().getSignedUserName())
              .matches(WebElement::isDisplayed)
              .extracting(WebElement::getText)
              .isEqualTo("Roman");
        softly.assertAll();

    }
}
