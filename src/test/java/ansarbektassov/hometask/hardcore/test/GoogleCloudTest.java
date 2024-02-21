package ansarbektassov.hometask.hardcore.test;

import ansarbektassov.hometask.hardcore.page.GoogleCloudCalculatorPage;
import ansarbektassov.hometask.hardcore.page.GoogleCloudPage;
import ansarbektassov.hometask.hardcore.page.YopMailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleCloudTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void checkEmailEstimatePriceTest() throws InterruptedException {
        GoogleCloudPage googleCloudPage = new GoogleCloudPage(driver);
        GoogleCloudCalculatorPage googleCloudCalculatorPage = googleCloudPage
                .openPage()
                .enterSearchTerm("Google Cloud Platform Pricing Calculator")
                .selectCalculatorReference()
                .switchToFrame()
                .enterNumberOfInstances(4)
                .chooseN1Series()
                .checkAddGPU()
                .enterGPUType()
                .enterGPUNumber()
                .enterLocalSsd()
                .enterLocation()
                .enterUsage()
                .enterAddToEstimateButton()
                .pullEstimationPrice();
        String calculatorEstimatePriceValue = googleCloudCalculatorPage.getCalculatorEstimatedPrice();
        String emailEstimatePriceValue = googleCloudCalculatorPage.openEmailEstimateForm()
                .openPage()
                .enterEmail("ansar")
                .copyEmail()
                .switchToFrame()
                .sendEstimateByEmail()
                .refreshEmails()
                .switchToFrameInbox()
                .selectLatestEmail()
                .switchToFrameEmail()
                .getEmailEstimatePriceValue();

        Assert.assertEquals(emailEstimatePriceValue,calculatorEstimatePriceValue);
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
        driver = null;
    }
}
