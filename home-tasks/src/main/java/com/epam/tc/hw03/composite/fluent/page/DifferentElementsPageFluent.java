package com.epam.tc.hw03.composite.fluent.page;

import com.epam.tc.hw03.composite.fluent.component.Checkbox;
import com.epam.tc.hw03.composite.fluent.component.LogReader;
import org.openqa.selenium.WebDriver;

public class DifferentElementsPageFluent extends AbstractIndexPageFluent {
    protected Checkbox checkbox;
    protected LogReader logReader;

    public DifferentElementsPageFluent(WebDriver driver) {
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
