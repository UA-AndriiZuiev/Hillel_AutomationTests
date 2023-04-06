import com.hillel.homework_11.pageObjects.HomePage;
import com.hillel.homework_11.pageObjects.QaAutotestPage;
import com.hillel.homework_11.driver.WebDriverFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test_AutoQAHillelUa {
    private static WebDriver driver = WebDriverFactory.getDriver();
    private static By xpathQaAutotest = By.xpath("//a[@class='-icon-square course-bar -icon-square'][@href='https://ithillel.ua/courses/qa-automation']");

    public static void main(String[] args) {

        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.onClick(xpathQaAutotest);

        QaAutotestPage qaAutotestPage = new QaAutotestPage(driver);
        qaAutotestPage.ensureOpened();

        Assertions.assertEquals("Курс QA Automation", qaAutotestPage.getCourseTitle(), "Title is not equals 'Курс QA Automation'");
        Assertions.assertEquals("4.9", qaAutotestPage.getCourseRate(), "Course Rate is not 4.9");

        driver.quit();
    }
}