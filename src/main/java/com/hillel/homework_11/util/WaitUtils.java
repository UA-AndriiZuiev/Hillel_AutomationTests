package com.hillel.homework_11.util;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private static final long TIMEWAIT = 10;
    private static WebDriverWait wait;

    public static void waitUtilsIsClickable(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, TIMEWAIT);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUtilsTextPresentInElement(WebDriver driver, WebElement element, String text) {
        wait = new WebDriverWait(driver, TIMEWAIT);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void waitUtilsElementInvisibility(WebDriver driver, By xpathElement) {
        wait = new WebDriverWait(driver, TIMEWAIT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathElement));
    }
    
    public static void waitUtilsElementIsVisible(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, TIMEWAIT);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}