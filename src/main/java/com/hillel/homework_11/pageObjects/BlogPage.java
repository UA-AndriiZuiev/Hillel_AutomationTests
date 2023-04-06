package com.hillel.homework_11.pageObjects;

import com.hillel.homework_11.driver.Wrapper;
import com.hillel.homework_11.util.ConfigProvider;
import com.hillel.homework_11.util.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BlogPage extends BasePage {
    private By xpathPublicationsBnt = By.xpath("//button[@class='site-nav-link'][@data-dropdown-trigger='publications']");
    private By xpathBlogLogo = By.xpath("//span[@class='site-logo-link'][@href='https://blog.ithillel.ua/']");
    private By xpathListTeam = By.xpath("//ul[@class='site-nav-publications_list']/li");

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

    public WebElement blogPublicationsBtn() {
        WebElement publicationsBtn = driver.findElement(xpathPublicationsBnt);
        return publicationsBtn;
    }

    public List<WebElement> listPublications() {
        List<WebElement> list = Wrapper.ListElements(driver, xpathListTeam);
        return list;
    }
}