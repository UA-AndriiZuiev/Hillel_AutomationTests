package cucumber.steps;

import com.hillel.homework_11.driver.Wrapper;
import com.hillel.homework_11.pageObjects.BasePage;
import com.hillel.homework_11.pageObjects.HomePage;
import com.hillel.homework_11.util.WaitUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class HomePageSteps extends BaseUISteps{
    private BasePage page = null;
    @Given("Open Home page")
    public void openPage(){
        page = new HomePage(driver);
        page.open();
    }
    @Then("Verify opened Home page")
    public void verifyVisibleElement_Logo(){
        Assert.assertTrue(((HomePage)page).getLogo().isDisplayed(), "Hillel logo at Home page is not displayed");
    }
    @Given("Go to Checking page")
    public void openCheckPage(){
        ((HomePage)page).getSchoolButton().click();
        WaitUtils.waitUtilsElementIsVisible(driver, ((HomePage)page).getCheckCertificationButton());
        Assert.assertTrue(((HomePage)page).getCheckCertificationButton().isDisplayed(), "Button " +
                ((HomePage)page).getCheckCertificationButton().getText() + "  is not displayed");
        ((HomePage)page).getCheckCertificationButton().click();
    }
    @Then("Verify opened Checking page")
    public void verifyVisibleText_CheckCertification(){
        Assert.assertTrue(((HomePage)page).getTextCheckCertification().isDisplayed(), "Text " +
                ((HomePage)page).getTextCheckCertification().getText() + " at Check Certification page is not displayed");
    }
    @Given("Check {} of certification")
    public void checkCertification(String CertificateNumber){
        ((HomePage)page).getInputField().sendKeys((CertificateNumber));
        Wrapper.isClickable(driver, ((HomePage)page).getCheckButton());
        Assert.assertTrue(((HomePage)page).getCheckButton().isEnabled());
        ((HomePage)page).getCheckButton().click();
    }
    @Then("Check {} text")
    public void verifyResult(String result){
        WaitUtils.waitUtilsElementIsVisible(driver, ((HomePage)page).getResultText());
        Assert.assertEquals(((HomePage)page).getResultText().getText(), result);
    }
}