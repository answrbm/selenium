package ansarbektassov.hometask.bringiton.test;

import ansarbektassov.hometask.bringiton.page.PastebinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PastebinTest {

    private WebDriver driver;
    private String code;
    private String title;

    @BeforeMethod(alwaysRun = true)
    public void initDriver() {
        driver = new ChromeDriver();
        code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        title = "how to gain dominance among developers";
    }

    @Test
    public void checkPasteContentTest() {
        String pasteContentValue = new PastebinPage(driver)
                .openPage()
                .enterPasteContent(code)
                .selectBashSyntaxHighlighting()
                .select10MinutesExpiration()
                .enterPasteTitle(title)
                .submitForm()
                .getContentValue();

        Assert.assertEquals(pasteContentValue,code);
    }

    @Test
    public void checkPasteTitleTest() {
        String pasteTitleValue = new PastebinPage(driver)
                .openPage()
                .enterPasteContent(code)
                .selectBashSyntaxHighlighting()
                .select10MinutesExpiration()
                .enterPasteTitle(title)
                .submitForm()
                .getTitleValue();

        Assert.assertEquals(pasteTitleValue,title);
    }

    @Test
    public void checkSyntaxHighlightingTest() {
        String pasteSyntaxHighlightingValue = new PastebinPage(driver)
                .openPage()
                .enterPasteContent(code)
                .selectBashSyntaxHighlighting()
                .select10MinutesExpiration()
                .enterPasteTitle(title)
                .submitForm()
                .getSyntaxHighlightingValue();

        Assert.assertEquals(pasteSyntaxHighlightingValue,"Bash");
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
        driver = null;
    }
}
