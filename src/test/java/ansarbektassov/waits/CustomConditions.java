package ansarbektassov.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {

    public static ExpectedCondition<WebElement> customCondition() {
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver input) {
                return input.findElement(By.id("example"));
            }
        };
    }
}
