package com.epam.tc.hw03.composite.component.ex2;

import com.epam.tc.hw03.composite.component.AbstractBaseComponent;
import com.epam.tc.hw03.composite.utils.StringEditorForLogs;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Log extends AbstractBaseComponent {

    @FindBy(xpath = "//li[contains(text(), 'Water')]")
    private WebElement waterLogger;

    @FindBy(xpath = "//li[contains(text(), 'Wind')]")
    private WebElement windLogger;

    @FindBy(xpath = "//li[contains(text(), 'Selen')]")
    private WebElement metalLogger;

    @FindBy(xpath = "//li[contains(text(), 'Yellow')]")
    private WebElement colorLogger;

    @FindBy(className = "info-panel-section")
    private WebElement logSection;

    public Log(WebDriver driver) {
        super(driver);
    }

    public List<String> getListOfLogs() {
        return List.of(
            yellowColorLog(),
            selenRadioLog(),
            windCheckboxLog(),
            waterCheckboxLog()
        );
    }

    public String waterCheckboxLog() {
        return StringEditorForLogs.cutTimeOfLogString(waterLogger.getText());
    }

    public String windCheckboxLog() {
        return StringEditorForLogs.cutTimeOfLogString(windLogger.getText());
    }

    public String selenRadioLog() {
        return StringEditorForLogs.cutTimeOfLogString(metalLogger.getText());
    }

    public String yellowColorLog() {
        return StringEditorForLogs.cutTimeOfLogString(colorLogger.getText());
    }

    public void visibilityOfLogSection() {
        wait.until(ExpectedConditions.visibilityOf(logSection));
    }


}
