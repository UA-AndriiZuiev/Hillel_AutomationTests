package testNg;

import com.hillel.homework_11.listeners.RetryListenerExample;
import com.hillel.homework_11.pageObjects.BlogPage;
import com.hillel.homework_11.pageObjects.HomePage;
import com.hillel.homework_11.data.DataProviderMethods;
import com.hillel.homework_11.driver.Wrapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Log4j2
public class TestNgClass extends BaseTest {

    private final HomePage homePage = new HomePage(driver);
    private final BlogPage blogPage = new BlogPage(driver);

    @Test(dataProvider = "Source", dataProviderClass = DataProviderMethods.class,
            retryAnalyzer = RetryListenerExample.class)
    public void frontEndNewsTest(String topicForTest, int count) {

        String xpathList = "//ul[@class='posts_list post-list']/li";
        homePage.open();
        log.info("Homepage is opened");
        Wrapper.onClick(driver, homePage.getBlogBtnElement());
        blogPage.ensureOpened();
        blogPage.blogPublicationsBtn().click();
        Wrapper.onClickSelective(topicForTest, blogPage.listPublications());
        Assertions.assertEquals(count, Wrapper.ListNews(driver, By.xpath(xpathList)).size(), "Wrong amount of news");
    }
}