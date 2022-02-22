package com.epam.tc.hw03.composite.component.ex1;

import com.epam.tc.hw03.composite.component.AbstractBaseComponent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Icons extends AbstractBaseComponent {
    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitText;

    public Icons(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getBenefitForIcons() {
        return benefitText;
    }

    public List<WebElement> getIcons() {
        return benefitIcons;
    }

}
