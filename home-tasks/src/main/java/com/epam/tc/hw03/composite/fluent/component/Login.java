package com.epam.tc.hw03.composite.fluent.component;

import com.epam.tc.hw03.composite.component.AbstractBaseComponent;
import com.epam.tc.hw03.composite.fluent.page.IndexPageForExTwoFluent;
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

    public Login clickToDropdownLoginWindow() {
        dropdownLoginCaret.click();
        return this;
    }

    public Login ensureVisibilityOfLoginDropdownMenu() {
        wait.until(ExpectedConditions.visibilityOf(dropdownLoginWindow));
        return this;
    }

    public Login sendLoginName(final String name) {
        loginName.sendKeys(name);
        return this;
    }

    public Login sendLoginPassword(final String password) {
        loginPassword.sendKeys(password);
        return this;
    }

    public IndexPageForExTwoFluent clickToSignIn() {
        logInButton.click();
        return new IndexPageForExTwoFluent(driver);
    }

    public IndexPageForExTwoFluent signIn(final String name, final String password) {
        dropdownLoginCaret.click();
        wait.until(ExpectedConditions.visibilityOf(dropdownLoginWindow));
        loginName.sendKeys(name);
        loginPassword.sendKeys(password);
        logInButton.click();
        return new IndexPageForExTwoFluent(driver);
    }

    public WebElement getSignedUserName() {
        return signedUserName;
    }
}
