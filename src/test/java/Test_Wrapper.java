import com.hillel.homework_11.driver.WebDriverFactory;
import com.hillel.homework_11.driver.Wrapper;
import com.hillel.homework_11.util.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test_Wrapper {

    private static WebDriver driver = WebDriverFactory.getDriver();
    private static Wrapper wrapper;
    private static WebElement element;
    private static By xpathProgrammingBtn = By.xpath("//a[@href='https://ithillel.ua/courses/programming']");
    private static By xpathLogoHomePage = By.xpath("//a[@class='site-logo-link'][@href='https://ithillel.ua/']");
    private static By xpathJavaProBtn = By.xpath("//a[@class='-icon-square course-bar -icon-square'][@href='https://ithillel.ua/courses/java-pro']");

    public static void main(String[] args) {
        driver.get(ConfigProvider.BASE_URL);
        driver.manage().window().maximize();

        element = driver.findElement(xpathProgrammingBtn);
        wrapper.onClick(driver, element);

        element = driver.findElement(xpathLogoHomePage);
        wrapper.onClick(driver, element, xpathLogoHomePage);

        element = driver.findElement(xpathJavaProBtn);
        wrapper.isClickable(driver, element);

        driver.quit();
    }
}