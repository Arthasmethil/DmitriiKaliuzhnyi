package com.epam.tc.hw3.fluent;

import static com.epam.tc.hw3.constants.ExpectedValuesConstants.EXPECTED_TEXT_LOG_WITHOUT_TIME;
import static com.epam.tc.hw3.constants.ExpectedValuesConstants.EXPECTED_TITLE;
import static com.epam.tc.hw3.constants.ExpectedValuesConstants.HEADER_DROPDOWN_SERVICE;

import com.epam.tc.hw03.composite.fluent.page.IndexPageForExTwoFluent;
import com.epam.tc.hw3.steps.SeleniumAbstractCore;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExerciseAssertJTestFluent extends SeleniumAbstractCore {

    @Test
    public void checkAndSearchElementsOnDifferentElementsPage() {
        IndexPageForExTwoFluent indexPageForExTwoFluent = new IndexPageForExTwoFluent(driver);
        // 1. Open test site by URL in setUp method
        // 2. Assert Browser title
        Assertions.assertThat(driver.getTitle()).isEqualTo(EXPECTED_TITLE);
        // 3. User is logged
        indexPageForExTwoFluent.login().signIn(propertiesData.getName(), propertiesData.getPassword());
        // 4. Name is displayed and equals to expected result
        Assertions.assertThat(indexPageForExTwoFluent.login().getSignedUserName())
                  .matches(WebElement::isDisplayed)
                  .extracting(WebElement::getText)
                  .isEqualTo(propertiesData.getExpectedDisplayedName());
        // 5-8 Open through the header menu Service -> Different Elements Page
        List<String> listOfLogs = indexPageForExTwoFluent
            .headMenu()
            .clickOnItem(HEADER_DROPDOWN_SERVICE)// 5.1 Dropdown caret is opened
            .navigateToDifferentElementsPage() // Open Different Elements Page
            .checkboxes()
            .selectAllEnableCheckboxes() // 6. Select checkboxes, 7. Select radio, 8. Select color
            .logger()
            .visibilityOfLogSection() // wait for logs
            .getListOfLogs(); // get a list of logs
        // 9. Assert that for each checkbox there is an individual log row and value
        Assertions.assertThat(listOfLogs)
              .hasSize(EXPECTED_TEXT_LOG_WITHOUT_TIME.size())
              .containsExactlyElementsOf(EXPECTED_TEXT_LOG_WITHOUT_TIME);
        // 10. Browser is closed by tearDown method, which is located into utils.SeleniumCoreTest
    }
}
