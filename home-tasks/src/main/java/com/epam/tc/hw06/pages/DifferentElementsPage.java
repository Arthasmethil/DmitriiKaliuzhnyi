package com.epam.tc.hw06.pages;

import com.epam.tc.hw06.component.ex2.Checkbox;
import com.epam.tc.hw06.component.ex2.LogReader;
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
