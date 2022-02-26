package com.epam.tc.hw04.pages;

import com.epam.tc.hw04.component.ex2.ServiceDropdownMenu;
import org.openqa.selenium.WebDriver;

public class IndexPageForExTwo extends AbstractIndexPage {
    protected ServiceDropdownMenu dropdownHeaderMenu;

    public IndexPageForExTwo(WebDriver driver) {
        super(driver);
        dropdownHeaderMenu = new ServiceDropdownMenu(driver);
    }

    public ServiceDropdownMenu dropdownServiceMenu() {
        return this.dropdownHeaderMenu;
    }
}
