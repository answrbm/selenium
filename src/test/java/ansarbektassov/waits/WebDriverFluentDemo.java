package ansarbektassov.waits;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class WebDriverFluentDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1));
//        driver.manage().timeouts().scriptTimeout(Duration.ofMillis(1));
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));

        driver.get("http://seleniumhq.org");
        WebElement elem1 = new WebDriverWait(driver, Duration.ofSeconds(10)).until(
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

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                        .pollingEvery(Duration.ofSeconds(3))
                                .ignoring(NoSuchElementException.class)
                                        .ignoring(StaleElementReferenceException.class)
                                                .withMessage("Timeout for waiting for search result list was exceeded!");

        wait.until(ExpectedConditions.titleIs("java"));

        driver.quit();
    }
}
