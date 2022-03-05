package com.epam.tc.hw05.pages;

import com.epam.tc.hw05.component.domain.ServiceDropdownMenu;
import org.openqa.selenium.WebDriver;

public class IndexPage extends AbstractIndexPage {
    protected ServiceDropdownMenu dropdownHeaderMenu;

    public IndexPage(WebDriver driver) {
        super(driver);
        dropdownHeaderMenu = new ServiceDropdownMenu(driver);
    }

    public ServiceDropdownMenu dropdownServiceMenu() {
        return this.dropdownHeaderMenu;
    }

    public void open() {
        openIndexPage();
    }
}
