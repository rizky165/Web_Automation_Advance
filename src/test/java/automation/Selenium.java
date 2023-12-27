package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseWebTest;
import org.openqa.selenium.WebElement;


import java.time.Duration;


public class Selenium extends BaseWebTest {


    @Test
    public void loginTestSucces(){
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(20));

        WebElement ButtonSearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='Search']")));
        ButtonSearch.click();

        WebElement Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button buttonSecondry buttonBig fontSize12 relative']")));
        Button.click();

        String txtActualResult = driver.get().findElement(By.xpath("//div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']")).getText();
        String txtExpectedResult = driver.get().findElement(By.xpath("//div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']")).getText();
        Assert.assertEquals(txtExpectedResult, txtActualResult);

        System.out.println("Actual Result = " + txtActualResult);
        System.out.println("Expected Result = " + txtExpectedResult);

    }

}



