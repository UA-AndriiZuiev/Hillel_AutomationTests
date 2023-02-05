package com.hillel.homework_11.driver;

import com.hillel.homework_11.util.ConfigProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactory {
    private static final String BROWSER = System.getProperty("browser");
    private static WebDriver driver;

    public static WebDriver getDriver() {
        String browserType = BROWSER != null ? BROWSER : ConfigProvider.BROWSER;
        driver = getDriver(Browsers.valueOf(browserType.toUpperCase()));
        return driver;
    }

    public static WebDriver getDriver(Browsers browsers) {
        switch (browsers) {
            case OPERA:
                return getOperaDriver();
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            case EDGE:
                return getEdgeDriver();
            default:
                throw new IllegalArgumentException("Wrong browser chooses");
        }
    }

    private static WebDriver getOperaDriver() {
        if (driver == null) {
            WebDriverManager.operadriver().setup();
            return new OperaDriver();
        }
        return new OperaDriver();
    }

    private static WebDriver getChromeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        return new ChromeDriver();
    }

    private static WebDriver getFirefoxDriver() {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        return new FirefoxDriver();
    }

    private static WebDriver getEdgeDriver() {
        if (driver == null) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
        return new EdgeDriver();
    }
}