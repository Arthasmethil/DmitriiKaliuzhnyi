package com.epam.tc.hw03.composite.fluent.page;

import com.epam.tc.hw03.composite.fluent.component.Checkbox;
import com.epam.tc.hw03.composite.fluent.component.Log;
import org.openqa.selenium.WebDriver;

public class DifferentElementsPageFluent extends AbstractIndexPageFluent {
    protected Checkbox checkbox;
    protected Log log;

    public DifferentElementsPageFluent(WebDriver driver) {
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
