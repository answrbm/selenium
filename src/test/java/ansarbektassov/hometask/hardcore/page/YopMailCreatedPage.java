package ansarbektassov.hometask.hardcore.page;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class YopMailCreatedPage {

    private static String PAGE_URL;

    private final WebDriver driver;

    @FindBy(xpath = "//div[@class='bname']")
    private WebElement emailName;
    @FindBy(xpath = "//h2")
    private WebElement emailEstimatePrice;
    @FindBy(xpath = "//button[@id='refresh']")
    private WebElement refreshButton;

    public YopMailCreatedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public YopMailCreatedPage switchToFrameInbox() {
        driver.switchTo().frame("ifinbox");
        return this;
    }

    public YopMailCreatedPage switchToFrameEmail() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("ifmail");
        return this;
    }

    public GoogleCloudCalculatorPage copyEmail() {
//        new WebDriverWait(driver, Duration.ofSeconds(20))
//                .until(ExpectedConditions.visibilityOf(emailName));
        Actions actions = new Actions(driver);
        actions.moveToElement(emailName);
        String email = emailName.getText();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudCalculatorPage(driver);
        calculatorPage.setEmail(email);

        String originHandle = driver.getWindowHandle();

        for(String handle : driver.getWindowHandles()) {
            if(!handle.equals(originHandle))
                driver.switchTo().window(handle);
        }
        return calculatorPage;
    }

    public YopMailCreatedPage refreshEmails() {
        refreshButton.click();
        return this;
    }

    public YopMailCreatedPage selectLatestEmail() {
        List<WebElement> emails = driver.findElements(By.xpath("//div[@class='mctn']/div[@class='m']"));
        WebElement latestEmail = emails.get(0);
        latestEmail.click();
        return this;
    }

    public String getEmailEstimatePriceValue() {
        return emailEstimatePrice.getText().split(":")[1].trim();
    }
}
