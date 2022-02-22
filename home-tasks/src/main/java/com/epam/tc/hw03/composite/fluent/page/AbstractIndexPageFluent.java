package com.epam.tc.hw03.composite.fluent.page;

import com.epam.tc.hw03.composite.fluent.component.HeaderMenu;
import com.epam.tc.hw03.composite.fluent.component.Login;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractIndexPageFluent {
    public static final int WAIT_FOR_ELEMENTS_SECONDS = 15;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Login login;
    protected HeaderMenu headerMenu;

    protected AbstractIndexPageFluent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENTS_SECONDS));
        PageFactory.initElements(this.driver, this);
        login = new Login(driver);
        headerMenu = new HeaderMenu(driver);
    }

    public Login login() {
        return this.login;
    }

    public HeaderMenu headMenu() {
        return this.headerMenu;
    }
}
