package ansarbektassov.hometask.bringiton.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PastebinCreatedPage {

    private static String PAGE_URL;
    WebDriver driver;

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement titleElement;
    @FindBy(xpath = "//ol[@class='bash']")
    private WebElement contentElement;
    @FindBy(xpath = "//div[@class='expire']")
    private WebElement expirationElement;
    @FindBy(xpath = "//div[@class='left']/a[contains(@href, '/archive/')]")
    private WebElement syntaxHighlightingElement;

    public PastebinCreatedPage(WebDriver driver, String pageUrl) {
        PAGE_URL = pageUrl;
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getContentValue() {
        StringBuilder codeString = new StringBuilder();
        List<WebElement> codeLines = contentElement.findElements(By.xpath("//li[@class='li1']"));
        for(WebElement codeLine : codeLines) {
            List<WebElement> codeParts = codeLine.findElements(By.xpath("//div[@class='de1']/*"));
            for(WebElement codePart : codeParts) {
                String codePartString = codePart.getText();
                System.out.println(codePartString);
                codeString.append(codePartString);
            }
            codeString.append("\r\n");
        }
        System.out.println(codeString);
        return codeString.toString();
    }

    public String getTitleValue() {
        return titleElement.getText();
    }

    public String getExpirationValue() {
        return expirationElement.getText();
    }

    public String getSyntaxHighlightingValue() {
        return syntaxHighlightingElement.getText();
    }
}
