package com.epam.tc.jdi.example;

import static com.epam.tc.jdi.JdiTestSite.homePage;
import static com.epam.tc.jdi.pages.HomePage.loginForm;
import static com.epam.tc.jdi.pages.HomePage.userIcon;

import com.epam.tc.jdi.JdiTestInit;
import com.epam.tc.jdi.entities.User;
import com.epam.tc.jdi.support.PropertiesProvider;
import org.testng.annotations.Test;

public class JdiSubmitChangesTest implements JdiTestInit {
    PropertiesProvider propertiesProvider = new PropertiesProvider();


    //@Test
    //public void nonPageObjectTest() {
    //    WebPage.openUrl("https://jdi-testing.github.io/jdi-light/index.html");
    //    $("img#user-icon").click();
    //    $("form #name").input("Roman");
    //    $("form #password").input("Jdi1234");
    //    $("form [type=submit]").click();
    //    Assert.assertEquals(WebPage.getUrl(), "https://jdi-testing.github.io/jdi-light/index.html");
    //}

    @Test
    public void loginTest() {
        homePage.open();
        userIcon.click();
        loginForm.loginAs(new User("Roman", "Jdi1234"));
        homePage.checkOpened();
    }
}
