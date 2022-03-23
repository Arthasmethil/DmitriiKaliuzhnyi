package com.epam.tc.jdi.entities;

import com.epam.tc.jdi.support.PropertiesProvider;

public class DefaultUser {

    static PropertiesProvider properties = new PropertiesProvider();

    public static User DEFAULT_USER = new User(
        properties.getProperty("name"),
        properties.getProperty("password"),
        properties.getProperty("displayed.name"));
}
