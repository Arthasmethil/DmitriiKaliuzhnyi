package com.epam.tc.jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.jdi.sections.LoginForm;
import org.openqa.selenium.WebElement;


@Title("Home Page")
@Url("/index.html")
public class HomePage extends WebPage {

    @Css("form") public static LoginForm loginForm;
    @Css("img#user-icon") public static Icon userIcon;
    @Css(".fa-sign-out") public static WebElement logout;

}
