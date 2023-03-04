package JUnit;

import com.hillel.homework_11.PageObjects.*;
import com.hillel.homework_11.driver.WebDriverFactory;
import com.hillel.homework_11.driver.Wrapper;
import com.hillel.homework_11.util.ConfigProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class FirstTest extends BaseTest {
    private WebDriver driver = WebDriverFactory.getDriver();
    BlogPage blogPage = new BlogPage(driver);
    HomePage homePage = new HomePage(driver);
    PublicationsFrontEndPage publicationsFrontEndPage = new PublicationsFrontEndPage(driver);
    PublicationsQAPage publicationsQAPage = new PublicationsQAPage(driver);
    PublicationsGameDevPage publicationsGameDevPage = new PublicationsGameDevPage(driver);

    @Test
    public void frontEndNewsTest() {
        homePage.open();
        Wrapper.onClick(driver, homePage.getBlogBtnElement());
        blogPage.ensureOpened();
        Wrapper.onClick(driver, blogPage.BlogPublicationsBtn());
        Wrapper.onClick(driver, blogPage.FrontEndBtnElement());
        Assertions.assertEquals(ConfigProvider.NEWSCOUNT_FRONTENDPAGE, publicationsFrontEndPage.ListNews().size(), "Wrong amount of news at Front-end page");
    }

    @Test
    public void qaNewsTest() {
        homePage.open();
        Wrapper.onClick(driver, homePage.getBlogBtnElement());
        blogPage.ensureOpened();
        Wrapper.onClick(driver, blogPage.BlogPublicationsBtn());
        Wrapper.onClick(driver, blogPage.getQABntElement());
        Assertions.assertEquals(ConfigProvider.NEWSCOUNT_QAPAGE, publicationsQAPage.ListNews().size(), "Wrong amount of news at QA page");
    }

    @Test
    public void gameDevTest() {
        homePage.open();
        Wrapper.onClick(driver, homePage.getBlogBtnElement());
        blogPage.ensureOpened();
        Wrapper.onClick(driver, blogPage.BlogPublicationsBtn());
        Wrapper.onClick(driver, blogPage.getGameDevBntElement());
        Assertions.assertEquals(ConfigProvider.NEWSCOUNT_GAMEDEVPAGE, publicationsGameDevPage.ListNews().size(), "Wrong amount of news at GameDev page");
    }
}