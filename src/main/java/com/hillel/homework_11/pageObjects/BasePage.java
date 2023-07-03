package com.hillel.homework_11.pageObjects;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void open();

    public abstract void ensureOpened();
}