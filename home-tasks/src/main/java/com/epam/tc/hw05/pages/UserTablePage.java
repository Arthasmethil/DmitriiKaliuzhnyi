package com.epam.tc.hw05.pages;

import com.epam.tc.hw05.component.domain.UserTable;
import org.openqa.selenium.WebDriver;

public class UserTablePage extends AbstractIndexPage {
    protected UserTable userTable;

    public UserTablePage(WebDriver driver) {
        super(driver);
        userTable = new UserTable(driver);
    }

    public UserTable userTable() {
        return this.userTable;
    }
}
