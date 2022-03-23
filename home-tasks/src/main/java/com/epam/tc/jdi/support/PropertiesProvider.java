package com.epam.tc.jdi.support;

import java.io.InputStream;
import java.util.Properties;
import lombok.SneakyThrows;

public class PropertiesProvider {

    private static final String PATH_TO_PROPERTIES = "jdi/jdi.properties";
    private static Properties properties;

    @SneakyThrows
    public PropertiesProvider() {
        InputStream fileInputStream = getClass().getClassLoader().getResourceAsStream(PATH_TO_PROPERTIES);
        properties = new Properties();
        properties.load(fileInputStream);
        if (fileInputStream != null) {
            fileInputStream.close();
        }
    }

    public String getProperty(String property) {
        return properties.getProperty(property);
    }
}
