package com.epam.tc.hw04.support;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import lombok.SneakyThrows;

public class PropertiesProvider {
    private static final String PATH_TO_PROPERTIES = "src/test/resources/hw3/hw3.properties";
    private static Properties properties;

    @SneakyThrows
    public PropertiesProvider() {
        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Incorrect file path to properties");
        }
    }

    public String getProperty(String property) {
        return properties.getProperty(property);
    }
}
