package com.epam.tc.jdi.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class HeaderMenu extends Section {

    @UI("//a[contains(text(), 'Metals & Colors')]")
    public UIElement metalAndColorsBtn;
}
