package com.epam.tc.hw2.steps;

import com.epam.tc.hw2.constants.ConstantsForUserAndTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInSteps {

    public static void signIn(WebDriverWait wait) {
        openLoginCaret(wait);
        sendLoginName(wait, ConstantsForUserAndTests.USERNAME);
        sendLoginPass(wait, ConstantsForUserAndTests.PASS);
        logInSubmit(wait);
    }


    public static void openLoginCaret(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".navbar-right > li > a > span[class='caret']")))
            .click();
    }

    public static void sendLoginName(WebDriverWait wait, String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")))
            .sendKeys(name);
    }

    public static void sendLoginPass(WebDriverWait wait, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")))
            .sendKeys(password);
    }

    public static void logInSubmit(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("login-button")))
            .click();
    }
}
