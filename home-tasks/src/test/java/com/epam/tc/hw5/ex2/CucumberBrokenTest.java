package com.epam.tc.hw5.ex2;

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

@Epic(Tags.FAILED_TESTS)
public class CucumberBrokenTest extends SeleniumAbstractCore {

    @Story(Tags.FAILED_STORY)
    @Test(description = "Failure",
          dataProvider = "testDataForJenkins",
          dataProviderClass = DataProviderTest.class)
    @Description("This test is a failure")
    public void checkAndSearchElementsOnPageWithSoftAsserts(DataForTests data) {
        AssertionStep assertionStep = new AssertionStep(driver, wait);
        ActionStep actionStep = new ActionStep(driver, wait);

        // "1. Open test site by URL in setUp method"

        // "2. Assert Browser title"
        assertionStep.assertBrowserTitle("Unexpected title");

        // "3. User is logged"
        actionStep.login(data.getLogin(), data.getPassword());

        // "4. Name is displayed and equals to expected result"
        assertionStep.assertSignedUsername("Roman");

    }
}
