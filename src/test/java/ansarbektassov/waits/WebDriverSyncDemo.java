package ansarbektassov.waits;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverSyncDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1));
//        driver.manage().timeouts().scriptTimeout(Duration.ofMillis(1));
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));

        driver.get("http://seleniumhq.org");
        WebElement elem1 = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main_navbar\"]/ul/li[7]/div/a"))
        );
        elem1.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement elem2 = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main_navbar\"]/ul/li[7]/div/ul/li[4]/a"))
        );
        elem2.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement elem3 = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main_navbar\"]/ul/li[3]/a"))
        );
        elem3.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement elem4 = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"docsearch-1\"]/button/span[1]/span"))
        );
        elem4.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement elem5 = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"docsearch-input\"]"))
        );
        elem5.sendKeys("java");
        elem5.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> elems6 = new WebDriverWait(driver,Duration.ofSeconds(10)).until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div/div[1]/div/main/div"))
        );

        System.out.println(elems6.get(0).getAccessibleName());



        driver.quit();
    }
}
