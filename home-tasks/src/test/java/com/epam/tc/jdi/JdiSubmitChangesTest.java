package com.epam.tc.jdi;

import static com.epam.tc.jdi.JdiTestSite.metalAndColorsPage;
import static com.epam.tc.jdi.entities.DefaultUser.DEFAULT_USER;
import static com.epam.tc.jdi.pages.HomePage.assertDisplayedName;
import static com.epam.tc.jdi.pages.HomePage.header;

import com.epam.tc.jdi.data.provider.DataProviderTest;
import com.epam.tc.jdi.support.MetalColorsData;
import org.testng.annotations.Test;


public class JdiSubmitChangesTest implements JdiTestInit {

    @Test(dataProvider = "testDataForJdi",
          dataProviderClass = DataProviderTest.class)
    public void fillMetalColorsFormTest(MetalColorsData data) {

        assertDisplayedName(DEFAULT_USER);

        header.metalAndColorsBtn.click();

        metalAndColorsPage.checkOpened();

        metalAndColorsPage.fillMetalColorForm(data);

        metalAndColorsPage.assertFilledForm(data);

    }
}
