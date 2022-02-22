package com.epam.tc.hw3.ex2;

import static com.epam.tc.hw3.constants.ExpectedValuesConstants.EXPECTED_TEXT_LOG_WITHOUT_TIME;
import static com.epam.tc.hw3.constants.ExpectedValuesConstants.EXPECTED_TITLE;
import static com.epam.tc.hw3.constants.ExpectedValuesConstants.HEADER_DROPDOWN_SERVICE;

import com.epam.tc.hw03.composite.pages.DifferentElementsPage;
import com.epam.tc.hw03.composite.pages.IndexPageForExTwo;
import com.epam.tc.hw3.steps.SeleniumAbstractCore;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExerciseAssertJTest extends SeleniumAbstractCore {

    @Test
    public void checkAndSearchElementsOnDifferentElementsPage() {
        IndexPageForExTwo indexPageForExTwo = new IndexPageForExTwo(driver);
        // 1. Open test site by URL in setUp method
        // 2. Assert Browser title
        Assertions.assertThat(driver.getTitle()).isEqualTo(EXPECTED_TITLE);
        // 3. User is logged
        indexPageForExTwo.login().signIn(propertiesData.getName(), propertiesData.getPassword());
        // 4. Name is displayed and equals to expected result
        Assertions.assertThat(indexPageForExTwo.login().getSignedUserName())
                  .matches(WebElement::isDisplayed)
                  .extracting(WebElement::getText)
                  .isEqualTo(propertiesData.getExpectedDisplayedName());
        // 5. Open through the header menu Service -> Different Elements Page
        // 5.1 Dropdown caret is opened
        indexPageForExTwo.headMenu().clickOnItem(HEADER_DROPDOWN_SERVICE);
        // 5.2 Different elements is selected
        indexPageForExTwo.dropdownServiceMenu().navigateToDifferentElementsPage();
        // 6. Select checkboxes, 7. Select radio, 8. Select color
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        differentElementsPage.checkboxes().selectAllEnableCheckboxes();
        // 9. Assert that for each checkbox there is an individual log row and value
        differentElementsPage.logger().visibilityOfLogSection();
        Assertions.assertThat(differentElementsPage.logger().getListOfLogs())
              .hasSize(EXPECTED_TEXT_LOG_WITHOUT_TIME.size())
              .containsExactlyElementsOf(EXPECTED_TEXT_LOG_WITHOUT_TIME);
        // 10. Browser is closed by tearDown method, which is located into utils.SeleniumCoreTest
    }
}
