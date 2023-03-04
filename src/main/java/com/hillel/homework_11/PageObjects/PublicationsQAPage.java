package com.hillel.homework_11.PageObjects;

import com.hillel.homework_11.driver.Wrapper;
import com.hillel.homework_11.util.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PublicationsQAPage extends BasePage {

    public PublicationsQAPage(WebDriver driver) {
        super(driver);
    }

    private By xpathListNews = By.xpath("//ul[@class='posts_list post-list']/li");

    public List ListNews() {
        Wrapper.ScrollPageDown(driver);
        List<WebElement> webElementList = driver.findElements(xpathListNews);
        return webElementList;
    }

    @Override
    public void open() {
        driver.get(ConfigProvider.QA_PAGE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
    }
}