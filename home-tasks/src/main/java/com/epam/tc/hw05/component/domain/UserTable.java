package com.epam.tc.hw05.component.domain;

import com.epam.tc.hw05.component.AbstractBaseComponent;
import com.epam.tc.hw05.utils.StringEditorForLogs;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class UserTable extends AbstractBaseComponent {

    @FindBy(className = "main-content-hg")
    private WebElement mainContent;

    @FindBy(css = ".logs > li")
    private List<WebElement> userLogs;

    @FindBy(className = "info-panel-section")
    private WebElement logSection;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(css = "tr span")
    private List<WebElement> userDescription;

    @FindBy(css = "tr select")
    private List<WebElement> userDropdown;

    @FindBy(css = "tr a")
    private List<WebElement> usernames;

    @FindBy(xpath = "//tr/td[1][contains(text(),'')]")
    private List<WebElement> userNumbers;

    public UserTable(WebDriver driver) {
        super(driver);
    }

    public List<String> logSection() {
        wait.until(ExpectedConditions.visibilityOf(logSection));
        return userLogs.stream()
                       .map(WebElement::getText)
                       .map(StringEditorForLogs::cutTimeOfLogString)
                       .collect(Collectors.toList());
    }

    public void clickOnCheckbox(String username) {
        mainContent.findElements(By.id(username.toLowerCase(Locale.ROOT))).get(0).click();
    }

    public List<User> getUserList() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < usernames.size(); i++) {
            users.add(new User(
                userNumbers.get(i).getText(),
                usernames.get(i).getText(),
                userDescription.get(i).getText().replace("\n", " ")
            ));
        }
        return users;
    }

    public List<String> getUserDropdownValues(String username) {
        return mainContent
            .findElements((By.xpath("//tr[contains(.,'" + username + "')]/td/select/*")))
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }
}
