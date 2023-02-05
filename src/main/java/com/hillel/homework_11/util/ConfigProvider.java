package com.hillel.homework_11.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {
    private static final String CONFIG_PATH = "config.properties";
    private static final Properties PROP = initProperties();
    public static String BROWSER = PROP.getProperty("browser");
    public static String BASE_URL = PROP.getProperty("base.url");

    private ConfigProvider() {
    }

    private static Properties initProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Could not load property file", e);
        }
        return properties;
    }
}