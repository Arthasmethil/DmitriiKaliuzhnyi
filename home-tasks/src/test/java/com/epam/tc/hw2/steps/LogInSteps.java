package com.epam.tc.hw2.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInSteps {

    public static void signIn(WebDriver driver, WebDriverWait wait, String name, String password) {
        openLoginCaret(driver);
        visibilityOfLoginDropdownMenu(wait);
        sendLoginName(driver, name);
        sendLoginPass(driver, password);
        logInSubmit(driver);
    }


    public static void openLoginCaret(WebDriver driver) {
        driver.findElement(By.cssSelector("li.uui-profile-menu")).click();
    }

    public static void sendLoginName(WebDriver driver, String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public static void sendLoginPass(WebDriver driver, String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public static void logInSubmit(WebDriver driver) {
        driver.findElement(By.id("login-button")).click();
    }

    public static void visibilityOfLoginDropdownMenu(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dropdown-menu-login")));
    }
}
