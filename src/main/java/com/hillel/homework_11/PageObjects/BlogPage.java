package com.hillel.homework_11.PageObjects;

import com.hillel.homework_11.driver.Wrapper;
import com.hillel.homework_11.util.ConfigProvider;
import com.hillel.homework_11.util.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogPage extends BasePage {
    private By xpathPublicationsBnt = By.xpath("//button[@class='site-nav-link'][@data-dropdown-trigger='publications']");
    private By xpathBlogLogo = By.xpath("//span[@class='site-logo-link'][@href='https://blog.ithillel.ua/']");
    private By xpathListPublications = By.xpath("//ul[@class='site-nav-publications_list']/li");
    private By xpathFrontEndBnt = By.xpath("//a[@href='https://blog.ithillel.ua/publications/frontend']");
    private By xpathQABtn = By.xpath("//a[@href='https://blog.ithillel.ua/publications/qa']");
    private By xpathGameDevBtn = By.xpath("//a[@href='https://blog.ithillel.ua/publications/gamedev']");

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProvider.BLOG_PAGE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        WebElement blogLogo = driver.findElement(xpathBlogLogo);
        WaitUtils.waitUtilsElementIsVisible(driver, blogLogo);
    }

    public WebElement BlogPublicationsBtn() {
        WebElement publicationsBtn = driver.findElement(xpathPublicationsBnt);
        Wrapper.isClickable(driver, publicationsBtn);
        return publicationsBtn;
    }

    public WebElement FrontEndBtnElement() {
        WebElement frontEndBtn = driver.findElement(xpathFrontEndBnt);
        Wrapper.isClickable(driver, frontEndBtn);
        return frontEndBtn;
    }

    public WebElement getQABntElement() {
        WebElement qABtn = driver.findElement(xpathQABtn);
        Wrapper.isClickable(driver, qABtn);
        return qABtn;
    }

    public WebElement getGameDevBntElement() {
        WebElement gameDevBtn = driver.findElement(xpathGameDevBtn);
        Wrapper.isClickable(driver, gameDevBtn);
        return gameDevBtn;
    }
}