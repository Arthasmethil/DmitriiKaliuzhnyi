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
public class CucumberIndexPageTest extends SeleniumAbstractCore {

    @Story(Tags.SUCCESS_STORY)
    @Test(dataProvider = "testDataForJenkins",
          dataProviderClass = DataProviderTest.class)
    @Description("Asserts with steps annotations, one of the way to test step by step")
    public void checkAndSearchElementsOnPageWithSoftAsserts(DataForTests data) {
        AssertionStep assertionStep = new AssertionStep(driver, wait);
        ActionStep actionStep = new ActionStep(driver, wait);

        // 1. Open test site by URL in setUp method
        // 2. Assert Browser title
        assertionStep.assertBrowserTitle(data.getTitle());

        actionStep.login(data.getLogin(), data.getPassword());

        // 4. Name is displayed and equals to expected result
        assertionStep.assertSignedUsername(data.getDisplayedName());

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionStep.assertHeaderItemsExists(data.getExpectedTextHeadMenu());

        // "6. Assert that there are 4 images on the Index Page and they are displayed"
        assertionStep.assertIconsDisplayed(data.getExpectedTextIcons());

        // "7. Assert that there are 4 texts on the Index Page under icons and they have proper text"
        assertionStep.assertTextUnderIconsDisplayed(data.getExpectedTextIcons());

        // "8. Assert that there is the iframe with “Frame Button” exist"
        assertionStep.assertFrameExists();

        // "9. Switch to the iframe and check that there is “Frame Button” in the iframe"
        actionStep.switchToFrame();
        assertionStep.assertThatButtonInFrameExist();

        // "10. Switch to original window back"
        actionStep.switchToDefaultPage();

        // "11. Assert that there are 5 items in the Left Section are displayed and they have proper text"
        assertionStep.assertLeftMenuAreDisplayed(data.getExpectedTextLeftMenu());

    }
}
