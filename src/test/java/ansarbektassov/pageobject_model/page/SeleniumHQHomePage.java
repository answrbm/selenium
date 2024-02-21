package ansarbektassov.pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.XMLFormatter;

public class SeleniumHQHomePage {

    private static final String HOMEPAGE_URL = "http://seleniumhq.org";
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"main_navbar\"]/ul/li[7]/div/a")
    private WebElement languageList;

    @FindBy(xpath = "//*[@id=\"main_navbar\"]/ul/li[7]/div/ul/li[4]/a")
    private WebElement otherLanguage;

    @FindBy(xpath = "//*[@id=\"main_navbar\"]/ul/li[3]/a")
    private WebElement documentationButton;

    @FindBy(xpath = "//*[@id=\"docsearch-1\"]/button/span[1]/span")
    private WebElement searchDocumentationInput;

    @FindBy(xpath = "//*[@id=\"docsearch-1\"]/button")
    private WebElement searchInputWindow;

    private void waited() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public SeleniumHQHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public SeleniumHQHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        waited();
        return this;
    }

    public SeleniumHQHomePage changeLanguageToOther() {
        languageList.click();
        otherLanguage.click();
        waited();
        return this;
    }

    public SeleniumHQHomePage openDocumentationPage() {
        documentationButton.click();
        waited();
        return this;
    }

    public void searchForTerm(String term) {
        searchInputWindow.sendKeys(term);
        waited();
        searchInputWindow.sendKeys(Keys.ENTER);
        waited();

    }
}
