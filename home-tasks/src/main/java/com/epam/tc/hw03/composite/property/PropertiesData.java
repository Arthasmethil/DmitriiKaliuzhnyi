package com.epam.tc.hw03.composite.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesData {
    private static final String PATH_TO_PROPERTIES = "src/main/resources/hw3/hw3.properties";
    private final Properties properties;

    public PropertiesData() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return properties.getProperty("name");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getExpectedDisplayedName() {
        return properties.getProperty("expected.displayed.name");
    }

    public String getAddress() {
        return properties.getProperty("address");
    }
}
