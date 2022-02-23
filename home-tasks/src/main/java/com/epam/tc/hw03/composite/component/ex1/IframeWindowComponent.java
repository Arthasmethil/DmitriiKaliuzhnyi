package com.epam.tc.hw03.composite.component.ex1;

import com.epam.tc.hw03.composite.component.AbstractBaseComponent;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class IframeWindowComponent extends AbstractBaseComponent {

    @FindBy(id = "frame-button")
    private List<WebElement> iframeButton;

    public IframeWindowComponent(WebDriver driver) {
        super(driver);
    }

}
