package com.epam.tc.hw05.component.common;

import com.epam.tc.hw05.component.AbstractBaseComponent;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends AbstractBaseComponent {

    @FindBy(css = ".navbar-right > li > a > span[class='caret']")
    private WebElement dropdownLoginCaret;

    @FindBy(css = "div.dropdown-menu-login")
    private WebElement dropdownLoginWindow;

    @FindBy(id = "name")
    private WebElement loginName;

    @FindBy(id = "password")
    private WebElement loginPassword;

    @FindBy(id = "login-button")
    private WebElement logInButton;

    @FindBy(id = "user-name")
    @Getter
    private WebElement signedUserName;

    public Login(WebDriver driver) {
        super(driver);
    }

    @Step("Opening dropdown caret in header login window")
    public void clickToDropdownLoginWindow() {
        dropdownLoginCaret.click();
    }

    @Step("Ensuring that login window is visible")
    public void ensureVisibilityOfLoginDropdownMenu() {
        wait.until(ExpectedConditions.visibilityOf(dropdownLoginWindow));
    }

    @Step("Sending name for login")
    public void sendLoginName(final String name) {
        loginName.sendKeys(name);
    }

    @Step("Sending password for login")
    public void sendLoginPassword(final String password) {
        loginPassword.sendKeys(password);
    }

    @Step("Submitting")
    public void clickToSignIn() {
        logInButton.click();
    }

    @Step("Login step by step")
    public void signIn(final String name, final String password) {
        clickToDropdownLoginWindow();
        ensureVisibilityOfLoginDropdownMenu();
        sendLoginName(name);
        sendLoginPassword(password);
        clickToSignIn();
    }

}
