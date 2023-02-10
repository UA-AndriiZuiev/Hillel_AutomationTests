package com.hillel.homework_11.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private static final long TIMEWAIT = 5;
    private static WebDriverWait wait;

    public static void WaitUtilsIsClickable(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, TIMEWAIT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void WaitUtilsIsVisible(WebDriver driver, WebElement element, String text) {
        wait = new WebDriverWait(driver, TIMEWAIT);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}