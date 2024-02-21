package ansarbektassov.hometask.icanwin.test;

import ansarbektassov.hometask.icanwin.page.PastebinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PastebinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void checkPasteContentTest() {
        String pasteContentValue = new PastebinPage(driver)
                .openPage()
                .enterPasteContent("Hello from WebDriver")
                .select10MinutesExpiration()
                .enterPasteTitle("helloweb")
                .submitForm()
                .getContentValue();

        Assert.assertEquals(pasteContentValue,"Hello from WebDriver");
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
        driver = null;
    }
}
