package com.epam.tc.hw03.composite.component.common;

import com.epam.tc.hw03.composite.component.AbstractBaseComponent;
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
    private WebElement signedUserName;

    public Login(WebDriver driver) {
        super(driver);
    }

    public void clickToDropdownLoginWindow() {
        dropdownLoginCaret.click();
    }

    public void visibilityOfLoginDropdownMenu() {
        wait.until(ExpectedConditions.visibilityOf(dropdownLoginWindow));
    }

    public void sendLoginName(final String name) {
        loginName.sendKeys(name);
    }

    public void sendLoginPassword(final String password) {
        loginPassword.sendKeys(password);
    }

    public void clickToSignIn() {
        logInButton.click();
    }

    public void signIn(final String name, final String password) {
        clickToDropdownLoginWindow();
        visibilityOfLoginDropdownMenu();
        sendLoginName(name);
        sendLoginPassword(password);
        clickToSignIn();
    }

    public WebElement getSignedUserName() {
        return signedUserName;
    }
}
