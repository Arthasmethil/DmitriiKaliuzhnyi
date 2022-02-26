package com.epam.tc.hw04.component.ex2;

import com.epam.tc.hw04.component.AbstractBaseComponent;
import com.epam.tc.hw04.utils.StringEditorForLogs;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogReader extends AbstractBaseComponent {

    @FindBy(css = ".logs > li")
    private List<WebElement> logList;

    @FindBy(className = "info-panel-section")
    private WebElement logSection;

    public LogReader(WebDriver driver) {
        super(driver);
    }

    public List<String> getListOfLogs() {
        wait.until(ExpectedConditions.visibilityOf(logSection));
        return logList.stream()
                      .map(WebElement::getText)
                      .map(StringEditorForLogs::cutTimeOfLogString)
                      .collect(Collectors.toList());
    }

}
