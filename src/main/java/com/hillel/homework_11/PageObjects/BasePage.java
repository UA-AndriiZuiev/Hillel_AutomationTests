package com.hillel.homework_11.PageObjects;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void open();

    public abstract void ensureOpened();
}