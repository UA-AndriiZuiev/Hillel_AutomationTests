package com.hillel.homework_11.driver;

import org.openqa.selenium.*;
import com.hillel.homework_11.util.WaitUtils;
import org.openqa.selenium.interactions.Actions;

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

    public static void ScrollPageDown(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);
        long lastHeight = 0;
        long  height = 1;
        
        while (lastHeight != height) {
            action.pause(1200);
            action.sendKeys(Keys.END).build().perform();
            lastHeight = height;
            height = (long) js.executeScript("return document.body.scrollHeight");
        }
    }
}