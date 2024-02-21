package ansarbektassov.hometask.hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudSearchPage {

    private static final String PAGE_URL = "https://cloud.google.com/search";
    private final WebDriver driver;

    @FindBy(xpath = "//a[@href='https://cloud.google.com/products/calculator-legacy?hl=es-419']")
    private WebElement calculatorReference;

    public GoogleCloudSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public GoogleCloudCalculatorPage selectCalculatorReference() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(calculatorReference));
        Actions actions = new Actions(driver);
        actions.moveToElement(calculatorReference);
        calculatorReference.click();
        return new GoogleCloudCalculatorPage(driver);
    }
}
