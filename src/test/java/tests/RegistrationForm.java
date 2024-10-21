package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import java.time.Duration;

public class RegistrationForm {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.NONE);
        driver = DriverFactory.open("chrome");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void fillRegistrationForm(){
        driver.get("https://moneygaming.qa.gameaccount.com");
        WebElement joinNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".newUser.green")));
        joinNowButton.click();
        driver.findElement(By.name("map(title)")).click();
        driver.findElement(By.xpath("//*[@id=\"title\"]/option[2]")).click();
        driver.findElement(By.name("map(firstName)")).sendKeys("Petar");
        driver.findElement(By.name("map(lastName)")).sendKeys("Tsolov");
        WebElement terms = driver.findElement(By.name("map(terms)"));
        if (!terms.isSelected()){
            terms.click();
        }
        driver.findElement(By.id("form")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"signupForm\"]/fieldset[1]/label[8]")).isDisplayed());
    }

//    @AfterMethod
//    public void closeBrowser(){
//        driver.close();
//    }
}