package ansarbektassov.hometask.hardcore.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YopMailPage {

    private static final String PAGE_URL = "https://yopmail.com/";

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='login']")
    private WebElement emailInput;

    public YopMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public YopMailPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public YopMailCreatedPage enterEmail(String email) {
        emailInput.sendKeys(email);
        emailInput.sendKeys(Keys.ENTER);
        return new YopMailCreatedPage(driver);
    }


}
