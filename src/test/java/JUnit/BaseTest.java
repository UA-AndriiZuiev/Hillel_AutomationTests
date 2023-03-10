package JUnit;

import com.hillel.homework_11.driver.WebDriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected static WebDriver driver = WebDriverFactory.getDriver();

    @BeforeAll
    public static void beforeAll() {
        driver = WebDriverFactory.getDriver();
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }
}