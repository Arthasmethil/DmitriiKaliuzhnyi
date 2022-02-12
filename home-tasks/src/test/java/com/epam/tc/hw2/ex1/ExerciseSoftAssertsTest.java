package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.constants.ConstantsForUserAndTests;
import com.epam.tc.hw2.utils.LogIn;
import com.epam.tc.hw2.utils.SeleniumAbstractCore;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExerciseSoftAssertsTest extends SeleniumAbstractCore {

    @Test
    public void checkAndSearchElementsOnPageWithSoftAsserts() {
        SoftAssert softAssert = new SoftAssert();
        // 1. Open test site by URL
        driver.get(ConstantsForUserAndTests.SITE_ADDRESS);
        // 2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        // 3. User is logged
        LogIn.signIn(wait);
        // 4. Name is displayed and equals to expected result
        softAssert.assertTrue(wait.until(ExpectedConditions
                                      .visibilityOfElementLocated(By.id("user-name")))
                                  .isDisplayed());
        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        // 5.1 HOME
        WebElement homeHeader = wait.until(ExpectedConditions
            .visibilityOfElementLocated(
                By.cssSelector(".m-l8 > li:nth-child(1) > a")));
        softAssert.assertTrue(homeHeader.isDisplayed());
        softAssert.assertEquals(homeHeader.getText(), "HOME");
        // 5.2 CONTACT FORM
        WebElement contactFormHeader = wait.until(ExpectedConditions
            .visibilityOfElementLocated(
                By.cssSelector(".m-l8 > li:nth-child(2) > a")));
        softAssert.assertTrue(contactFormHeader.isDisplayed());
        softAssert.assertEquals(contactFormHeader.getText(), "CONTACT FORM");
        // 5.3 SERVICE
        WebElement serviceHeader = wait.until(ExpectedConditions
            .visibilityOfElementLocated(
                By.cssSelector(".m-l8 > li.dropdown")));
        softAssert.assertTrue(serviceHeader.isDisplayed());
        softAssert.assertEquals(serviceHeader.getText(), "SERVICE");
        // 5.4 METALS & COLORS
        WebElement metalsAndColorsHeader = wait.until(ExpectedConditions
            .visibilityOfElementLocated(
                By.cssSelector(".m-l8 > li:nth-child(4) > a")));
        softAssert.assertTrue(metalsAndColorsHeader.isDisplayed());
        softAssert.assertEquals(metalsAndColorsHeader.getText(), "METALS & COLORS");
        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = wait.until(ExpectedConditions
            .visibilityOfAllElementsLocatedBy(By.className("benefit-icon")));
        for (WebElement icon : benefitIcons) {
            softAssert.assertTrue(icon.isDisplayed());
        }
        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitText = wait.until(ExpectedConditions
            .visibilityOfAllElementsLocatedBy(By.className("benefit-txt")));
        softAssert.assertEquals(benefitText.get(0).getText(), ConstantsForUserAndTests.EXPECTED_ICON_TEXT_ONE);
        softAssert.assertEquals(benefitText.get(1).getText(), ConstantsForUserAndTests.EXPECTED_ICON_TEXT_TWO);
        softAssert.assertEquals(benefitText.get(2).getText(), ConstantsForUserAndTests.EXPECTED_ICON_TEXT_THREE);
        softAssert.assertEquals(benefitText.get(3).getText(), ConstantsForUserAndTests.EXPECTED_ICON_TEXT_FOUR);
        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.id("frame")))
              .isDisplayed());
        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        softAssert.assertTrue(wait.until(ExpectedConditions
                                      .visibilityOfElementLocated(By.id("frame-button")))
                                  .isDisplayed());
        // 10. Switch to original window back
        driver.switchTo().defaultContent();
        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        // 11.1 HOME
        WebElement homeLeftBar = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.xpath("//span[text()='Home']")));
        softAssert.assertTrue(homeLeftBar.isDisplayed());
        softAssert.assertEquals(homeLeftBar.getText(), "Home");
        // 11.2 CONTACT FORM
        WebElement contactFormLeftBar = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[text()='Contact form']")));
        softAssert.assertTrue(contactFormLeftBar.isDisplayed());
        softAssert.assertEquals(contactFormLeftBar.getText(), "Contact form");
        // 11.3 SERVICE
        WebElement serviceLeftBar = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.xpath("//span[text()='Service']")));
        softAssert.assertTrue(serviceLeftBar.isDisplayed());
        softAssert.assertEquals(serviceLeftBar.getText(), "Service");
        // 11.4 METALS & COLORS
        WebElement metalsAndColorsLeftBar = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.xpath("//span[text()='Metals & Colors']")));
        softAssert.assertTrue(metalsAndColorsLeftBar.isDisplayed());
        softAssert.assertEquals(metalsAndColorsLeftBar.getText(), "Metals & Colors");
        // 11.5 ELEMENTS PACKS
        WebElement elementsPacksLeftBar = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.xpath("//span[text()='Elements packs']")));
        softAssert.assertTrue(elementsPacksLeftBar.isDisplayed());
        softAssert.assertEquals(elementsPacksLeftBar.getText(), "Elements packs");
        // 12. Assert all
        softAssert.assertAll();
        // 12.1 Browser is closed by tearDown method, which is located into utils.SeleniumCoreTest
    }
}
