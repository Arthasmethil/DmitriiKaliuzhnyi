package com.epam.tc.hw05.pages;

import com.epam.tc.hw05.component.domain.Checkbox;
import com.epam.tc.hw05.component.domain.LogReader;
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
