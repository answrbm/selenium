package ansarbektassov.hometask.hardcore.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleCloudCalculatorPage {

    private final static String PAGE_URL = "https://cloud.google.com/products/calculator-legacy";

    private WebDriver driver;
    private String calculatorEstimatedPrice;
    private String email;

    @FindBy(xpath = "//input[@id='input_100']")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//md-select[@name='series']")
    private WebElement seriesButton;
    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement optionN1;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_96']")
    private WebElement machineType;
    @FindBy(xpath = "//md-option[@id='select_option_474']")
    private WebElement machineTypeOption;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUCheckbox;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    private WebElement gpuType;
    @FindBy(xpath = "//md-option[@id='select_option_518']")
    private WebElement gpuTypeOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement gpuNumber;
    @FindBy(xpath = "//md-option[@id='select_option_520']")
    private WebElement gpuNumberOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSsd;
    @FindBy(xpath = "//md-option[@id='select_option_495']")
    private WebElement localSsdOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement location;
    @FindBy(xpath = "//md-option[@id='select_option_268']")
    private WebElement locationOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement committedUsage;
    @FindBy(xpath = "//md-option[@id='select_option_138']")
    private WebElement committedUsageOption;

    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//button[@title='Email Estimate']")
    private WebElement emailEstimateButton;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//button[contains(@ng-click,'emailQuote.emailQuote(true);')]")
    private WebElement sendEmailButton;


    public GoogleCloudCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public GoogleCloudCalculatorPage switchToFrame() {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        return this;
    }

    public GoogleCloudCalculatorPage enterNumberOfInstances(int number) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(numberOfInstancesInput));
        numberOfInstancesInput.click();
        numberOfInstancesInput.sendKeys(String.valueOf(number));
        return this;
    }

    public GoogleCloudCalculatorPage chooseN1Series() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(seriesButton));
        seriesButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(optionN1));
        optionN1.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(machineType));
        machineType.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(machineTypeOption));
        machineTypeOption.click();
        return this;
    }

    public GoogleCloudCalculatorPage checkAddGPU() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addGPUCheckbox));
        addGPUCheckbox.click();
        return this;
    }

    public GoogleCloudCalculatorPage enterGPUNumber() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(gpuNumber));
        gpuNumber.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(gpuNumberOption));
        gpuNumberOption.click();
        return this;
    }

    public GoogleCloudCalculatorPage enterGPUType() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(gpuType));
        gpuType.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(gpuTypeOption));
        gpuTypeOption.click();
        return this;
    }

    public GoogleCloudCalculatorPage enterLocalSsd() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(localSsd));
        localSsd.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(localSsdOption));
        localSsdOption.click();
        return this;
    }

    public GoogleCloudCalculatorPage enterLocation() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(location));
        location.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locationOption));
        locationOption.click();
        return this;
    }

    public GoogleCloudCalculatorPage enterUsage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(committedUsage));
        committedUsage.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(committedUsageOption));
        committedUsageOption.click();
        return this;
    }

    public GoogleCloudCalculatorPage enterAddToEstimateButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addToEstimateButton));
        addToEstimateButton.click();
        return this;
    }

    public GoogleCloudCalculatorPage pullEstimationPrice() {
        WebElement estimationPriceElem = driver.findElement(By.xpath("//div[@class='cpc-cart-total']/h2/b"));
        estimationPriceElem = new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(estimationPriceElem));
        String priceText = estimationPriceElem.getText();
        calculatorEstimatedPrice = priceText.split(":")[1].replaceAll("per 1 month","")
                .trim();
        return this;
    }

    public YopMailPage openEmailEstimateForm() {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(emailEstimateButton));
        emailEstimateButton.click();

        driver.switchTo().newWindow(WindowType.TAB);

        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        return new YopMailPage(driver);
    }

    public YopMailCreatedPage sendEstimateByEmail() throws InterruptedException {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(emailInput));
        Actions actions = new Actions(driver);
        actions.moveToElement(emailInput);
        emailInput.sendKeys(email);
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(sendEmailButton));
        sendEmailButton.click();

        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        Thread.sleep(5000);
        return new YopMailCreatedPage(driver);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCalculatorEstimatedPrice() {
        return calculatorEstimatedPrice;
    }
}

