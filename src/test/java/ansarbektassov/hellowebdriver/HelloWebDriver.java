package ansarbektassov.hellowebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWebDriver {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumhq.org");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        By by1 = By.xpath("//*[@id=\"main_navbar\"]/ul/li[7]/div/a");
        WebElement elem1 = driver.findElement(by1);
        elem1.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        By by2 = By.xpath("//*[@id=\"main_navbar\"]/ul/li[7]/div/ul/li[4]/a");
        WebElement elem2 = driver.findElement(by2);
        elem2.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        By by3 = By.xpath("//*[@id=\"main_navbar\"]/ul/li[3]/a");
        WebElement elem3 = driver.findElement(by3);
        elem3.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        By by4 = By.xpath("//*[@id=\"docsearch-1\"]/button/span[1]/span");
        WebElement elem4 = driver.findElement(by4);
        elem4.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        By by5 = By.xpath("//*[@id=\"docsearch-input\"]");
        WebElement elem5 = driver.findElement(by5);
        elem5.sendKeys("java");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        elem5.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

}
