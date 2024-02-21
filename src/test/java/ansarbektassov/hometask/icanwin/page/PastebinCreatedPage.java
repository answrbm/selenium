package ansarbektassov.hometask.icanwin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinCreatedPage {

    private static String PAGE_URL;
    WebDriver driver;

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement titleElement;
    @FindBy(xpath = "//div[@class='de1']")
    private WebElement contentElement;
    @FindBy(xpath = "//div[@class='expire'")
    private WebElement expirationElement;

    public PastebinCreatedPage(WebDriver driver, String pageUrl) {
        PAGE_URL = pageUrl;
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PastebinCreatedPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public String getContentValue() {
        return contentElement.getText();
    }

    public String getTitleValue() {
        return titleElement.getText();
    }

    public String getExpirationValue() {
        return expirationElement.getText();
    }
}
