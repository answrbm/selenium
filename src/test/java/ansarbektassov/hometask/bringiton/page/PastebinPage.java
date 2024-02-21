package ansarbektassov.hometask.bringiton.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PastebinPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    WebDriver driver;


    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;
    @FindBy(xpath = "//a[@href='/site/auth-google'")
    private WebElement googleLoginButton;
    @FindBy(xpath = "//div[@data-email='bektasovansar@gmail.com']")
    private WebElement myAccount;
    @FindBy(xpath = "//a[@class='header__btn']")
    private WebElement newPasteButton;

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement pasteContent;
    @FindBy(xpath = "//span[@aria-labelledby='select2-postform-format-container']")
    private WebElement syntaxHighlightingOptions;
    @FindBy(xpath = "//span[@aria-labelledby='select2-postform-expiration-container']")
    private WebElement expirationOptions;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteTitleInput;
    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Create New Paste')]")
    private WebElement submitPasteButton;


    public PastebinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PastebinPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinPage login() {
        loginButton.click();
        googleLoginButton.click();
        myAccount.click();
        newPasteButton.click();
        return this;
    }

    public PastebinPage enterPasteContent(String content) {
        pasteContent.sendKeys(content);
        return this;
    }

    public PastebinPage select10MinutesExpiration() {
        Actions actions = new Actions(driver);
        actions.moveToElement(expirationOptions);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .elementToBeClickable(expirationOptions)).click();
        expirationOptions.sendKeys(Keys.ARROW_DOWN);
        expirationOptions.sendKeys(Keys.ARROW_DOWN);
        expirationOptions.sendKeys(Keys.ENTER);
        return this;
    }

    public PastebinPage selectBashSyntaxHighlighting() {
        Actions actions = new Actions(driver);
        actions.moveToElement(syntaxHighlightingOptions);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .elementToBeClickable(syntaxHighlightingOptions)).click();
        syntaxHighlightingOptions.sendKeys(Keys.ARROW_DOWN);
        syntaxHighlightingOptions.sendKeys(Keys.ENTER);
        return this;
    }

    public PastebinPage enterPasteTitle(String title) {
        pasteTitleInput.sendKeys(title);
        return this;
    }

    public PastebinCreatedPage submitForm() {
        submitPasteButton.click();
        return new PastebinCreatedPage(driver,driver.getCurrentUrl());
    }
}
