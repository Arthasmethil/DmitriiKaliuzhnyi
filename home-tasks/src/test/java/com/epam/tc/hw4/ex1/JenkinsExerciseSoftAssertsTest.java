package com.epam.tc.hw4.ex1;

import com.epam.tc.hw04.pages.IndexPageForExOne;
import com.epam.tc.hw04.support.Data;
import com.epam.tc.hw4.data.provider.DataProviderTest;
import com.epam.tc.hw4.steps.SeleniumAbstractCore;
import com.epam.tc.hw4.storynames.Tags;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Epic(Tags.SUCCESS_TESTS)
@Feature(Tags.SOFT_ASSERT_TEST_FEATURE)
public class JenkinsExerciseSoftAssertsTest extends SeleniumAbstractCore {

    @Story(Tags.INTEGRATION_SOFT_STORY)
    @Test(description = "Soft asserts test, exercise 1",
          dataProvider = "testDataForJenkins",
          dataProviderClass = DataProviderTest.class)
    @Description("Soft asserts with steps annotations, one of the way to test step by step")
    public void checkAndSearchElementsOnPageWithSoftAsserts(Data data) {
        SoftAssertions softly = new SoftAssertions();
        // "1. Open test site by URL in setUp method"

        // "2. Assert Browser title"
        softly.assertThat(driver.getTitle()).isEqualTo(data.getTitle());

        // "3. User is logged");
        IndexPageForExOne indexPageForExOne = new IndexPageForExOne(driver);
        indexPageForExOne.login().signIn(data.getLogin(), data.getPassword());

        // "4. Name is displayed and equals to expected result"
        softly.assertThat(indexPageForExOne.login().getSignedUserName())
              .matches(WebElement::isDisplayed)
              .extracting(WebElement::getText)
              .isEqualTo(data.getDisplayedName());
        // "5. Assert that there are 4 items on the header section are displayed and they have proper texts"

        softly.assertThat(indexPageForExOne.headMenu().getMenuItems())
              .hasSize(data.getExpectedTextHeadMenu().size())
              .allMatch(WebElement::isDisplayed, "WebElement should be display")
              .extracting(WebElement::getText)
              .containsExactlyElementsOf(data.getExpectedTextHeadMenu());

        // "6. Assert that there are 4 images on the Index Page and they are displayed"
        softly.assertThat(indexPageForExOne.icons().getBenefitIcons())
              .hasSize(data.getExpectedTextIcons().size())
              .allMatch(WebElement::isDisplayed, "WebElement should be display");

        // "7. Assert that there are 4 texts on the Index Page under icons and they have proper text"
        softly.assertThat(indexPageForExOne.icons().getBenefitText())
              .hasSize(data.getExpectedTextIcons().size())
              .allMatch(WebElement::isDisplayed, "WebElement should be display")
              .extracting(WebElement::getText)
              .containsExactlyElementsOf(data.getExpectedTextIcons());

        // "8. Assert that there is the iframe with “Frame Button” exist"
        softly.assertThat(indexPageForExOne.getIframe())
              .hasAtLeastOneElementOfType(WebElement.class)
              .allMatch(WebElement::isDisplayed);

        // "9. Switch to the iframe and check that there is “Frame Button” in the iframe"
        indexPageForExOne.switchToIframe();
        softly.assertThat(indexPageForExOne.iframeWindow().getIframeButton())
              .hasAtLeastOneElementOfType(WebElement.class)
              .allMatch(WebElement::isDisplayed);

        // "10. Switch to original window back"
        indexPageForExOne.switchToDefaultContent();

        // "11. Assert that there are 5 items in the Left Section are displayed and they have proper text"
        softly.assertThat(indexPageForExOne.leftMenu().getLeftMenu())
              .hasSize(data.getExpectedTextLeftMenu().size())
              .allMatch(WebElement::isDisplayed, "WebElement should be display")
              .extracting(WebElement::getText)
              .containsExactlyElementsOf(data.getExpectedTextLeftMenu());

        // "12. Assert all to complete test"
        softly.assertAll();

    }
}
