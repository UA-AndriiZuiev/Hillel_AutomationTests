package JUnit;

import com.hillel.homework_11.PageObjects.*;
import com.hillel.homework_11.driver.WebDriverFactory;
import com.hillel.homework_11.driver.Wrapper;
import com.hillel.homework_11.util.ConfigProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Stream;

public class FirstTest extends BaseTest {
    private WebDriver driver = WebDriverFactory.getDriver();
    BlogPage blogPage = new BlogPage(driver);
    HomePage homePage = new HomePage(driver);

    @ParameterizedTest
    @MethodSource("Source")
    public void frontEndNewsTest(String xpath, int count, String xpathList) {
        homePage.open();
        Wrapper.onClick(driver, homePage.getBlogBtnElement());
        blogPage.ensureOpened();
        Wrapper.onClick(driver, blogPage.BlogPublicationsBtn());
        //Wrapper.onClick(driver, blogPage.FrontEndBtnElement());
        Wrapper.onClick(driver, driver.findElement(By.xpath(xpath)));
        Assertions.assertEquals(count, Wrapper.ListNews(driver, By.xpath(xpathList)).size(), "Wrong amount of news");
    }

    @MethodSource
    public static Stream<Arguments> Source() {
        return Stream.of(
                Arguments.of("//a[@href='https://blog.ithillel.ua/publications/frontend']",
                        ConfigProvider.NEWSCOUNT_FRONTENDPAGE,
                        "//ul[@class='posts_list post-list']/li"),
                Arguments.of("//a[@href='https://blog.ithillel.ua/publications/qa']",
                        ConfigProvider.NEWSCOUNT_QAPAGE,
                        "//ul[@class='posts_list post-list']/li"),
                Arguments.of("//a[@href='https://blog.ithillel.ua/publications/gamedev']",
                        ConfigProvider.NEWSCOUNT_GAMEDEVPAGE,
                        "//ul[@class='posts_list post-list']/li")
        );
    }
}