package JUnit;

import com.hillel.homework_11.PageObjects.*;
import com.hillel.homework_11.driver.Wrapper;
import com.hillel.homework_11.util.ConfigProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.stream.Stream;

public class FirstTest extends BaseTest {
    //private WebDriver driver = WebDriverFactory.getDriver();
    private HomePage homePage = new HomePage(driver);
    private BlogPage blogPage = new BlogPage(driver);

    @ParameterizedTest
    @MethodSource("Source")
    public void frontEndNewsTest(String topicForTest, int count) {
        String xpathList = "//ul[@class='posts_list post-list']/li";
        homePage.open();
        Wrapper.onClick(driver, homePage.getBlogBtnElement());
        blogPage.ensureOpened();
        blogPage.blogPublicationsBtn().click();
        Wrapper.onClickSelective(topicForTest, blogPage.listPublications());
        Assertions.assertEquals(count, Wrapper.ListNews(driver, By.xpath(xpathList)).size(), "Wrong amount of news");
    }

    @MethodSource
    public static Stream<Arguments> Source() {
        return Stream.of(
                Arguments.of(ConfigProvider.topicForTest().get(0),
                        ConfigProvider.NEWSCOUNT_FRONTENDPAGE),
                Arguments.of(ConfigProvider.topicForTest().get(1),
                        ConfigProvider.NEWSCOUNT_QAPAGE),
                Arguments.of(ConfigProvider.topicForTest().get(2),
                        ConfigProvider.NEWSCOUNT_GAMEDEVPAGE)
        );
    }
}