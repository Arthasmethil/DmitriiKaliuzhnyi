package com.epam.tc.hw03.composite.pages;

import com.epam.tc.hw03.composite.component.ex2.Checkbox;
import com.epam.tc.hw03.composite.component.ex2.Log;
import org.openqa.selenium.WebDriver;

public class DifferentElementsPage extends AbstractIndexPage {
    protected Checkbox checkbox;
    protected Log log;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        checkbox = new Checkbox(driver);
        log = new Log(driver);
    }

    public Checkbox checkboxes() {
        return this.checkbox;
    }

    public Log logger() {
        return this.log;
    }
}
