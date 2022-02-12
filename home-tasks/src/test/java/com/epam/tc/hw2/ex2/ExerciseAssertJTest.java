package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.constants.ConstantsForUserAndTests;
import com.epam.tc.hw2.utils.LogIn;
import com.epam.tc.hw2.utils.RegexChecker;
import com.epam.tc.hw2.utils.SeleniumAbstractCore;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ExerciseAssertJTest extends SeleniumAbstractCore {

    @Test
    public void checkAndSearchElementsOnIndexPage() {
        // 1. Open test site by URL
        driver.get(ConstantsForUserAndTests.SITE_ADDRESS);
        // 2. Assert Browser title
        Assertions.assertThat(driver.getTitle()).isEqualTo("Home Page");
        // 3. User is logged
        LogIn.signIn(wait);
        // 4. Name is displayed and equals to expected result
        Assertions.assertThat(wait.until(ExpectedConditions
                                      .visibilityOfElementLocated(By.id("user-name")))
                                  .isDisplayed()).isTrue();
        // 5. Open through the header menu Service -> Different Elements Page
        // 5. Dropdown caret is opened
        wait.until(ExpectedConditions
            .elementToBeClickable(
                By.cssSelector(".m-l8 > li.dropdown")))
            .click();
        // 5. Different elements is selected
        wait.until(ExpectedConditions
                .elementToBeClickable(
                    By.xpath("//a[contains(text(),'Different elements')]")))
            .click();
        // 6. Select checkboxes
        // 6.1 Water checkbox
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/label[1]/*"))).click();
        // 6.2 Wind checkbox
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/label[3]/*"))).click();
        // 7. Select radio
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/label[4]/*"))).click();
        // 8. Select in dropdown
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Yellow')]"))).click();
        // 9. Assert that
        //
        // 9.1 for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //
        WebElement waterLog =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(), 'Water')]")));
        WebElement windLog =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(), 'Wind')]")));
        Assertions.assertThat(RegexChecker.cutTimeOfLogString(waterLog.getText()))
                  .isEqualTo("Water: condition changed to true");
        Assertions.assertThat(RegexChecker.cutTimeOfLogString(windLog.getText()))
                  .isEqualTo("Wind: condition changed to true");
        // 9.2 for radio button there is a log row and value is corresponded to the status of radio button
        WebElement selenLog =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(), 'Selen')]")));
        Assertions.assertThat(RegexChecker.cutTimeOfLogString(selenLog.getText()))
                  .isEqualTo("metal: value changed to Selen");
        // 9.3 for dropdown there is a log row and value is corresponded to the selected value.
        WebElement colorLog =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(), 'Yellow')]")));
        Assertions.assertThat(RegexChecker.cutTimeOfLogString(colorLog.getText()))
                  .isEqualTo("Colors: value changed to Yellow");
        // 10. Browser is closed by tearDown method, which is located into utils.SeleniumCoreTest
    }
}
