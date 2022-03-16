package com.epam.tc.jdi.data.provider;

import com.epam.tc.jdi.data.support.JsonMapper;
import com.epam.tc.jdi.support.MetalColorsData;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;

public class DataProviderTest {

    @DataProvider(name = "testDataForJdi")
    public static Object[][] testDataForJdi() {

        List<MetalColorsData> metalColorsData = new ArrayList<>(JsonMapper.parseJson().values());
        return new Object[][] {
            { metalColorsData.get(0) },
            { metalColorsData.get(1), },
            { metalColorsData.get(2), },
            { metalColorsData.get(3), },
            { metalColorsData.get(4), }
        };
    }
}
