package com.hillel.homework_11.util;

import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Properties;
import java.util.stream.Stream;

public class ConfigProvider {
    private static final String CONFIG_PATH = "config.properties";
    private static final Properties PROP = initProperties();
    public static String BROWSER = PROP.getProperty("browser");
    public static String BASE_URL = PROP.getProperty("base.url");
    public static String QA_AUTOMATION_PAGE_URL = PROP.getProperty("qaAutotestingPage.url");
    public static String BLOG_PAGE_URL = PROP.getProperty("blogPage.url");
    public static final int NEWSCOUNT_FRONTENDPAGE = 121;
    public static final int NEWSCOUNT_QAPAGE = 87;
    public static final int NEWSCOUNT_GAMEDEVPAGE = 5;
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