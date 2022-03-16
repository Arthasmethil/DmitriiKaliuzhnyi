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

        Object[][] objects = new Object[metalColorsData.size()][];

        for (int i = 0; i < metalColorsData.size(); i++) {
            objects[i] = new Object[1];
            objects[i][0] = metalColorsData.get(i);
        }
        return objects;
    }
}
