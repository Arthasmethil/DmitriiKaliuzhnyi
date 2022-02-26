package com.epam.tc.hw03.composite.pages;

import com.epam.tc.hw03.composite.component.ex2.Checkbox;
import com.epam.tc.hw03.composite.component.ex2.LogReader;
import org.openqa.selenium.WebDriver;

public class DifferentElementsPage extends AbstractIndexPage {
    protected Checkbox checkbox;
    protected LogReader logReader;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        checkbox = new Checkbox(driver);
        logReader = new LogReader(driver);
    }

    public Checkbox checkboxes() {
        return this.checkbox;
    }

    public LogReader readLogSection() {
        return this.logReader;
    }
}
