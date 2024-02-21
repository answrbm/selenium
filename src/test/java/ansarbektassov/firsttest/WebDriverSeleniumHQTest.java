package ansarbektassov.firsttest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebDriverSeleniumHQTest {

    @Test
    public void commonSearchTermReResultsNotEmpty() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://seleniumhq.org");
        WebElement elem1 = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main_navbar\"]/ul/li[7]/div/a"))
        );
        elem1.click();

        WebElement elem2 = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main_navbar\"]/ul/li[7]/div/ul/li[4]/a"))
        );
        elem2.click();

        WebElement elem3 = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main_navbar\"]/ul/li[3]/a"))
        );
        elem3.click();

        WebElement elem4 = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"docsearch-1\"]/button/span[1]/span"))
        );
        elem4.click();

        WebElement elem5 = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"docsearch-input\"]"))
        );
        elem5.sendKeys("java");
        elem5.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
