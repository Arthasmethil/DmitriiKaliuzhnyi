package com.epam.tc.hw5.cucumber.steps;

import static com.epam.tc.hw5.constants.ExpectedValuesConstants.EXPECTED_TEXT_LOG_WITHOUT_TIME;
import static com.epam.tc.hw5.constants.ExpectedValuesConstants.EXPECTED_TITLE;
import static com.epam.tc.hw5.constants.ExpectedValuesConstants.EXPECTED_USER_LOG;

import com.epam.tc.hw05.pages.DifferentElementsPage;
import com.epam.tc.hw05.pages.IndexPage;
import com.epam.tc.hw05.pages.UserTablePage;
import com.epam.tc.hw05.support.PropertiesProvider;
import com.epam.tc.hw5.cucumber.context.TestContext;
import com.epam.tc.hw5.support.DataForTests;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {
    protected IndexPage indexPage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;
    protected DataForTests data;
    protected PropertiesProvider properties;

    public AbstractStep() {
        WebDriver driver = TestContext.getInstance().getObject("driver", WebDriver.class);
        indexPage =  new IndexPage(driver);
        differentElementsPage =  new DifferentElementsPage(driver);
        userTablePage =  new UserTablePage(driver);
        properties = new PropertiesProvider();
        data = new DataForTests(EXPECTED_TITLE, properties.getProperty("name"), properties.getProperty("password"),
            properties.getProperty("displayed.name"), EXPECTED_TEXT_LOG_WITHOUT_TIME, EXPECTED_USER_LOG);
    }
}
