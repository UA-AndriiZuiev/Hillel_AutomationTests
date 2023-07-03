package com.hillel.homework_11.pageObjects;

import com.hillel.homework_11.util.ConfigProvider;
import com.hillel.homework_11.util.WaitUtils;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @Getter
    @FindBy(xpath = "//*[@class='section-content_logo']")
    private WebElement Logo;

    @Getter
    @FindBy(xpath = "//button[@data-dropdown-trigger='aboutSchool']")
    private WebElement SchoolButton;

    @Getter
    @FindBy(xpath = "//*[@class='site-nav-dropdown_link -certificate']")
    private WebElement CheckCertificationButton;

    @Getter
    @FindBy(xpath = "//h1[@class='welcome-screen_title hero-title']")
    private WebElement TextCheckCertification;

    @Getter
    @FindBy(xpath = "//input[@class='input -text certificate-check_input']")
    private WebElement InputField;

    @Getter
    @FindBy(xpath = "//button[@class='btn btn-submit -submit certificate-check_submit']")
    private WebElement CheckButton;

    @Getter
    @FindBy(xpath = "//p[@class='certificate-check_message']")
    private WebElement ResultText;

    private static By xpathBlogPageBtn= By.xpath("//a[@class='site-nav-link'][@href='https://blog.ithillel.ua']");

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        driver.get(ConfigProvider.BASE_URL);
        ensureOpened();
    }


    @Override
    public void ensureOpened() {
        WaitUtils.waitUtilsElementIsVisible(driver, Logo);
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