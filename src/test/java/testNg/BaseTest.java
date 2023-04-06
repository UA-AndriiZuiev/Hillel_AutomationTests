package testNg;

import com.hillel.homework_11.driver.WebDriverFactory;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

@Log4j2
public class BaseTest {
    protected static WebDriver driver = WebDriverFactory.getDriver();

    @BeforeMethod
    public void testStartedLog(Method method) {
        log.info("Test \"" + method.getName() + "\" started!");
    }

    @AfterMethod
    public void testFinishedLog(ITestResult result) {
        log.info(String.format("Test \"" + result.getMethod().getMethodName() + "\" is finished with result " + result.getStatus()));
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}