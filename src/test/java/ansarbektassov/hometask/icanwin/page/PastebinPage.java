package ansarbektassov.hometask.icanwin.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    WebDriver driver;

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement pasteContent;
    @FindBy(xpath = "//*[@id=\"w0\"]/div[5]/div[1]/div[1]/div/span/span[1]/span")
    private WebElement expirationOptions;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteTitleInput;
    @FindBy(xpath = "//*[@class='form-group form-btn-container']/button")
    private WebElement submitPasteButton;


    public PastebinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PastebinPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinPage enterPasteContent(String content) {
        pasteContent.sendKeys(content);
        return this;
    }

    public PastebinPage select10MinutesExpiration() {
        expirationOptions.click();
        expirationOptions.sendKeys(Keys.ARROW_DOWN);
        expirationOptions.sendKeys(Keys.ARROW_DOWN);
        expirationOptions.sendKeys(Keys.ENTER);
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
