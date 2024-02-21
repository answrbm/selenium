package ansarbektassov.hometask.hurtmeplenty.test;

import ansarbektassov.hometask.hurtmeplenty.page.GoogleCloudPage;
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
    public void checkProvisioningModelTest() {
        String provisioningModelValue = new GoogleCloudPage(driver)
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
                .getEstimationResult("Provisioning model");

        Assert.assertEquals(provisioningModelValue,"Regular");
    }

    @Test
    public void checkInstanceTypeTest() {
        String instanceTypeValue = new GoogleCloudPage(driver)
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
                .getEstimationResult("Instance type");

        Assert.assertEquals(instanceTypeValue,"n1-standard-8");
    }

    @Test
    public void checkRegionTest() {
        String regionValue = new GoogleCloudPage(driver)
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
                .getEstimationResult("Region");

        Assert.assertEquals(regionValue,"Frankfurt");
    }

    @Test
    public void checkLocalSsdTest() {
        String localSsdValue = new GoogleCloudPage(driver)
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
                .getEstimationResult("Local SSD");

        Assert.assertEquals(localSsdValue,"2x375 GiB");
    }

    @Test
    public void checkCommitmentTermTest() {
        String commitmentTermValue = new GoogleCloudPage(driver)
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
                .getEstimationResult("Commitment term");

        Assert.assertEquals(commitmentTermValue,"1 Year");
    }

    @Test
    public void checkTotalPriceTest() {
        String totalPrice = new GoogleCloudPage(driver)
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
                .getEstimationPrice();

        Assert.assertEquals(totalPrice,"USD 1,840.40 per 1 month");
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
        driver = null;
    }
}
