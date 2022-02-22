package com.epam.tc.hw03.composite.component.ex1;

import com.epam.tc.hw03.composite.component.AbstractBaseComponent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IframeWindowComponent extends AbstractBaseComponent {
    public static final String FRAME_ID_NAME = "frame";

    @FindBy(id = "frame")
    private List<WebElement> iframe;

    @FindBy(id = "frame-button")
    private List<WebElement> iframeButton;

    public IframeWindowComponent(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getIframe() {
        return iframe;
    }

    public List<WebElement> getIframeBtn() {
        return iframeButton;
    }
}
