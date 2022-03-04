package com.epam.tc.hw04.pages;

import com.epam.tc.hw04.component.common.HeaderMenu;
import com.epam.tc.hw04.component.common.LeftMenu;
import com.epam.tc.hw04.component.common.Login;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractIndexPage {
    public static final int WAIT_FOR_ELEMENTS_SECONDS = 15;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Login login;
    protected HeaderMenu headerMenu;
    protected LeftMenu leftMenu;

    protected AbstractIndexPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENTS_SECONDS));
        PageFactory.initElements(this.driver, this);
        login = new Login(driver);
        headerMenu = new HeaderMenu(driver);
        leftMenu = new LeftMenu(driver);
    }

    public Login login() {
        return this.login;
    }

    public HeaderMenu headMenu() {
        return this.headerMenu;
    }

    public LeftMenu leftMenu() {
        return this.leftMenu;
    }
}
