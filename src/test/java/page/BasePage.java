package page;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();

    public BasePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        this.driver = driver;
        this.explicitWait = explicitWait;
    }

    protected final void clickAndWait(WebElement element) {
        explicitWait.get().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected final void setText(WebElement element, String text) {
        explicitWait.get().until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    protected final String getText(WebElement element) {
        String actualText = explicitWait.get().until(ExpectedConditions.visibilityOf(element)).getText();
        return actualText;
    }
    protected final WebElement waitForElementVisibility(WebElement element) {
        return explicitWait.get().until(ExpectedConditions.visibilityOf(element));
    }

    protected final WebElement waitForClickable(By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver.get(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}