package cucumber.steps;

import com.hillel.homework_11.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class BaseUISteps {
    public static WebDriver driver = WebDriverFactory.getDriver();
    @AfterClass
    public void quitDriver(){
        driver.quit();
    }
}
