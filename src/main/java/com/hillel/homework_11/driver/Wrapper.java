package com.hillel.homework_11.driver;

import org.openqa.selenium.By;
import com.hillel.homework_11.util.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wrapper {

    private static WebDriver driver;

    public Wrapper(WebDriver driver) {
        this.driver = driver;
    }

    public static void onClick(WebDriver driver, WebElement element) {
        WaitUtils.waitUtilsIsClickable(driver, element);
        element.click();
    }

    public static void onClick(WebDriver driver, WebElement element, By xpathElement) {
        WaitUtils.waitUtilsIsClickable(driver, element);
        element.click();
        WaitUtils.waitUtilsElementInvisibility(driver, xpathElement);
    }

    public static void isClickable(WebDriver driver, WebElement element) {
        WaitUtils.waitUtilsIsClickable(driver, element);
    }
}