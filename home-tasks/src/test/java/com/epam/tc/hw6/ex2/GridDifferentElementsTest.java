package com.epam.tc.hw6.ex2;

import com.epam.tc.hw6.data.provider.DataProviderTest;
import com.epam.tc.hw6.data.support.DataForTests;
import com.epam.tc.hw6.steps.ActionStep;
import com.epam.tc.hw6.steps.AssertionStep;
import com.epam.tc.hw6.steps.SeleniumAbstractCore;
import org.testng.annotations.Test;

public class GridDifferentElementsTest extends SeleniumAbstractCore {

    @Test(dataProvider = "testDataForGrid",
          dataProviderClass = DataProviderTest.class)
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
