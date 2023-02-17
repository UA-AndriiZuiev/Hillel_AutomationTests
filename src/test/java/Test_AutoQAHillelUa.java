import com.hillel.homework_11.PageObjects.HomePage;
import com.hillel.homework_11.PageObjects.QaAutotestPage;
import com.hillel.homework_11.driver.WebDriverFactory;
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

        System.out.println(qaAutotestPage.getCourseTitle());
        System.out.println(qaAutotestPage.getCourseRate());

        driver.quit();
    }
}