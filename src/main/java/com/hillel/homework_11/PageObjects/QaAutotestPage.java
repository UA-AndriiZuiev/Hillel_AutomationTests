package com.hillel.homework_11.PageObjects;

import com.hillel.homework_11.util.ConfigProvider;
import com.hillel.homework_11.util.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QaAutotestPage extends BasePage {
    private static String xpathCourseTitle = "//span[@class='course-descriptor_header-text']";
    private static String xpathCourseRate = "//span[@class='course-rating_average']";
    private String xpathTitle = "//div[@class='course-descriptor']";

    public QaAutotestPage(WebDriver driver) {
        super(driver);
    }

    public String getCourseTitle() {
        WebElement courseTitle = driver.findElement
                (By.xpath(xpathCourseTitle));
        return courseTitle.getText();
    }

    public String getCourseRate() {
        WebElement courseRate = driver.findElement(By.xpath(xpathCourseRate));
        return courseRate.getText();
    }

    @Override
    public void open() {
        driver.get(ConfigProvider.QA_AUTOMATION_PAGE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        WebElement title = driver.findElement(By.xpath(xpathTitle));
        WaitUtils.waitUtilsElementIsVisible(driver, title);
    }
}