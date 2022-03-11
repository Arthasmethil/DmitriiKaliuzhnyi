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

    @Test
    public void loginTest() {
        homePage.open();
        userIcon.click();
        loginForm.loginAs(new User("Roman", "Jdi1234"));
        homePage.checkOpened();
    }
}
