import com.hillel.homework_11.driver.WebDriverFactory;
import com.hillel.homework_11.util.ConfigProvider;
import com.hillel.homework_11.util.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test_HillelUa {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(ConfigProvider.BASE_URL);
        driver.manage().window().maximize();

        WebElement labelTesting = driver.findElement
                (By.xpath("//p[@class='course-cat-bar_label'][contains(text(), 'Тестування')]"));

        WaitUtils.WaitUtilsIsClickable(driver, labelTesting);
        labelTesting.click();

        WebElement textHead = driver.findElement(By.xpath("//h1[@class='hero-title']"));
        WaitUtils.WaitUtilsIsVisible(driver, textHead, "Курси тестування");

        if (textHead.isDisplayed()) {
            System.out.println("Element " + textHead.getText() + " is displayed");
        } else {
            System.out.println("Element " + textHead.getText() + " is not displayed");
        }

        driver.quit();
    }
}