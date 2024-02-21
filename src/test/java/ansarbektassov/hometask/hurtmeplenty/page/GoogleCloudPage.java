package ansarbektassov.hometask.hurtmeplenty.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='YSM5S']")
    private WebElement searchButton;
    @FindBy(xpath = "//input[@id='i5']")
    private WebElement searchInput;



    public GoogleCloudPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public GoogleCloudPage openPage() {
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
        return this;
    }

    public GoogleCloudSearchPage enterSearchTerm(String searchTerm) {
        searchButton.click();
        searchInput.sendKeys(searchTerm);
        searchInput.sendKeys(Keys.ENTER);
        return new GoogleCloudSearchPage(driver);
    }



}
