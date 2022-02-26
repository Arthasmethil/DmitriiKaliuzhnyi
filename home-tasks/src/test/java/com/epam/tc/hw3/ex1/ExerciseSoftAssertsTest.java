package com.epam.tc.hw3.ex1;

import static com.epam.tc.hw3.constants.ExpectedValuesConstants.EXPECTED_ICON_TEXTS;
import static com.epam.tc.hw3.constants.ExpectedValuesConstants.EXPECTED_TEXT_HEADER_MENU;
import static com.epam.tc.hw3.constants.ExpectedValuesConstants.EXPECTED_TEXT_LEFT_MENU;
import static com.epam.tc.hw3.constants.ExpectedValuesConstants.EXPECTED_TITLE;

import com.epam.tc.hw03.composite.pages.IndexPageForExOne;
import com.epam.tc.hw3.steps.SeleniumAbstractCore;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExerciseSoftAssertsTest extends SeleniumAbstractCore {

    @Test
    public void checkAndSearchElementsOnPageWithSoftAsserts() {
        SoftAssertions softly = new SoftAssertions();
        IndexPageForExOne indexPageForExOne = new IndexPageForExOne(driver);
        // 1. Open test site by URL in setUp method
        // 2. Assert Browser title
        softly.assertThat(driver.getTitle()).isEqualTo(EXPECTED_TITLE);
        // 3. User is logged
        indexPageForExOne.login().signIn(properties.getProperty("name"), properties.getProperty("password"));
        // 4. Name is displayed and equals to expected result
        softly.assertThat(indexPageForExOne.login().getSignedUserName())
              .matches(WebElement::isDisplayed)
              .extracting(WebElement::getText)
              .isEqualTo(properties.getProperty("displayed.name"));
        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softly.assertThat(indexPageForExOne.headMenu().getMenuItems())
              .hasSize(EXPECTED_TEXT_HEADER_MENU.size())
              .allMatch(WebElement::isDisplayed, "WebElement should be display")
              .extracting(WebElement::getText)
              .containsExactlyElementsOf(EXPECTED_TEXT_HEADER_MENU);
        // 6. Assert that there are 4 images on the Index Page and they are displayed
        softly.assertThat(indexPageForExOne.icons().getBenefitIcons())
              .hasSize(EXPECTED_ICON_TEXTS.size())
              .allMatch(WebElement::isDisplayed, "WebElement should be display");
        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softly.assertThat(indexPageForExOne.icons().getBenefitText())
              .hasSize(EXPECTED_ICON_TEXTS.size())
              .allMatch(WebElement::isDisplayed, "WebElement should be display")
              .extracting(WebElement::getText)
              .containsExactlyElementsOf(EXPECTED_ICON_TEXTS);
        //8. Assert that there is the iframe with “Frame Button” exist
        softly.assertThat(indexPageForExOne.getIframe())
              .hasAtLeastOneElementOfType(WebElement.class)
              .allMatch(WebElement::isDisplayed);
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        indexPageForExOne.switchToIframe();
        softly.assertThat(indexPageForExOne.iframeWindow().getIframeButton())
              .hasAtLeastOneElementOfType(WebElement.class)
              .allMatch(WebElement::isDisplayed);
        // 10. Switch to original window back
        indexPageForExOne.switchToDefaultContent();
        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softly.assertThat(indexPageForExOne.leftMenu().getLeftMenu())
              .hasSize(EXPECTED_TEXT_LEFT_MENU.size())
              .allMatch(WebElement::isDisplayed, "WebElement should be display")
              .extracting(WebElement::getText)
              .containsExactlyElementsOf(EXPECTED_TEXT_LEFT_MENU);
        // 12. Assert all
        softly.assertAll();
        // 12.1 Browser is closed by tearDown method, which is located into utils.SeleniumCoreTest
    }
}
