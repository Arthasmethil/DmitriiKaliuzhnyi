package com.epam.tc.jdi.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.tc.jdi.entities.User;
import com.epam.tc.jdi.sections.HeaderMenu;
import com.epam.tc.jdi.sections.LoginForm;


@Title("Home Page")
@Url("/index.html")
public class HomePage extends WebPage {

    @Css("form")
    public static LoginForm loginForm;

    @Css("img#user-icon")
    public static Icon userIcon;

    @UI("//a[contains(text(), 'Metals & Colors')]")
    public static UIElement metalAndColorsBtn;

    @UI("#user-name")
    public static Text username;

    @UI(".logout")
    public static Button logout;

    public static HeaderMenu header;

    public static void assertDisplayedName(User user) {
        username.assertThat().text(user.displayedName);
    }

    public  static void logout() {
        userIcon.click();
        logout.click();
    }
}
