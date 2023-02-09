import com.hillel.homework_11.driver.WebDriverFactory;
import com.hillel.homework_11.util.ConfigProvider;
import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(ConfigProvider.BASE_URL);
        driver.quit();
    }
}