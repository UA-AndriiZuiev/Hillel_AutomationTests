package com.hillel.homework_11.pageObjects;

import com.hillel.homework_11.util.ConfigProvider;
import com.hillel.homework_11.util.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private static String xpathLogo = "//*[@class='section-content_logo']";
    private static By xpathBlogPageBtn= By.xpath("//a[@class='site-nav-link'][@href='https://blog.ithillel.ua']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProvider.BASE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        WebElement title = driver.findElement(By.xpath(xpathLogo));
        WaitUtils.waitUtilsElementIsVisible(driver, title);
    }

    public void onClick(By xpath) {
        WebElement element = driver.findElement(xpath);
        WaitUtils.waitUtilsIsClickable(driver, element);
        element.click();
    }

    public WebElement getBlogBtnElement(){
        return driver.findElement(xpathBlogPageBtn);
    }
}