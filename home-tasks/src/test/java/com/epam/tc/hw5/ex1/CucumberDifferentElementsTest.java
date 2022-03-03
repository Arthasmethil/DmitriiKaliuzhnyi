package com.epam.tc.hw5.ex1;

import com.epam.tc.hw05.support.DataForTests;
import com.epam.tc.hw5.provider.DataProviderTest;
import com.epam.tc.hw5.steps.ActionStep;
import com.epam.tc.hw5.steps.AssertionStep;
import com.epam.tc.hw5.steps.SeleniumAbstractCore;
import com.epam.tc.hw5.storynames.Tags;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic(Tags.SUCCESS_TESTS)
public class CucumberDifferentElementsTest extends SeleniumAbstractCore {

    @Test(dataProvider = "testDataForJenkins",
          dataProviderClass = DataProviderTest.class)
    @Description("Another path to test")
    @Story(Tags.SUCCESS_STORY)
    public void checkAndSearchElementsOnDifferentElementsPage(DataForTests data) {
        AssertionStep assertionStep = new AssertionStep(driver, wait);
        ActionStep actionStep = new ActionStep(driver, wait);

        // 1. Open test site by URL in setUp method
        // 2. Assert Browser title
        assertionStep.assertBrowserTitle(data.getTitle());

        // 3. User is logged
        actionStep.login(data.getLogin(), data.getPassword());

        // 4. Name is displayed and equals to expected result
        assertionStep.assertSignedUsername(data.getDisplayedName());

        // 5. Open through the header menu Service -> Different Elements Page
        actionStep.openDifferentElementsPage();

        // 6. Select checkboxes
        actionStep.selectCheckboxes();

        // 7. Select radio
        actionStep.selectRadio();

        // 8. Select color
        actionStep.selectColor();

        // "9. Assert that for each checkbox there is an individual log row and value"
        assertionStep.assertLogSectionWithLogsDisplayed(data.getExpectedTextLogs());
    }
}
