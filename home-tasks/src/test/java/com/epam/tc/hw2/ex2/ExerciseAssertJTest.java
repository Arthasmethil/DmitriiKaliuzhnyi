package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.constants.ExpectedValuesForTests;
import com.epam.tc.hw2.constants.User;
import com.epam.tc.hw2.steps.LogInSteps;
import com.epam.tc.hw2.steps.SeleniumAbstractCore;
import com.epam.tc.hw2.utils.StringEditorForLogs;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ExerciseAssertJTest extends SeleniumAbstractCore {

    @Test
    public void checkAndSearchElementsOnDifferentElementsPage() {
        // 1. Open test site by URL
        driver.get(ExpectedValuesForTests.SITE_ADDRESS);
        // 2. Assert Browser title
        Assertions.assertThat(driver.getTitle()).isEqualTo(ExpectedValuesForTests.EXPECTED_TITLE);
        // 3. User is logged
        LogInSteps.signIn(driver, wait, User.USERNAME, User.PASS);
        // 4. Name is displayed and equals to expected result
        Assertions.assertThat(driver.findElement(By.id("user-name")))
                  .matches(WebElement::isDisplayed)
                  .extracting(WebElement::getText)
                  .isEqualTo(User.EXPECTED_DISPLAYED_NAME);
        // 5. Open through the header menu Service -> Different Elements Page
        // 5.1 Dropdown caret is opened
        driver.findElement(By.cssSelector("li.dropdown")).click();
        // 5.2 Different elements is selected
        wait.until(ExpectedConditions
                .elementToBeClickable(
                    By.xpath("//a[contains(text(),'Different elements')]")))
            .click();
        // 6. Select checkboxes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main-content-hg")));
        driver.findElement(By.xpath("//label[@class='label-checkbox' and normalize-space(string())='Water']")).click();
        driver.findElement(By.xpath("//label[@class='label-checkbox' and normalize-space(string())='Wind']")).click();
        // 7. Select radio
        driver.findElement(By.xpath("//label[@class='label-radio' and normalize-space(string())='Selen']")).click();
        // 8. Select in dropdown
        driver.findElement(By.xpath("//option[contains(text(),'Yellow')]")).click();
        // 9. Assert that for each checkbox there is an individual log row and value
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("info-panel-section")));
        List<String> logStringWithoutTime = driver
            .findElements(By.cssSelector("ul.panel-body-list.logs > li"))
            .stream()
            .map(WebElement::getText)
            .map(StringEditorForLogs::cutTimeOfLogString)
            .collect(Collectors.toList());
        Assertions.assertThat(logStringWithoutTime)
              .hasSize(ExpectedValuesForTests.EXPECTED_TEXT_LOG_WITHOUT_TIME.size())
              .containsExactlyElementsOf(ExpectedValuesForTests.EXPECTED_TEXT_LOG_WITHOUT_TIME);
        // 10. Browser is closed by tearDown method, which is located into utils.SeleniumCoreTest
    }
}
