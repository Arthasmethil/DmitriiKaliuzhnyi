package com.epam.tc.hw05.component.ex1;

import com.epam.tc.hw05.component.AbstractBaseComponent;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class Icons extends AbstractBaseComponent {
    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitText;

    public Icons(WebDriver driver) {
        super(driver);
    }

}
