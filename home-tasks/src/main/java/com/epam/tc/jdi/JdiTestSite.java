package com.epam.tc.jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.jdi.pages.HomePage;
import com.epam.tc.jdi.pages.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiTestSite {

    @Url("/index.html")
    public static HomePage homePage;

    @Url("/metals-colors.html")
    public static MetalsAndColorsPage metalAndColorsPage;

}
